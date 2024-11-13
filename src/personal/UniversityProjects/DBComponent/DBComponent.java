package personal.UniversityProjects.DBComponent;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DBComponent {

    private static final String CONFIG_FILE_PATH = "/personal/UniversityProjects/DBComponent/Config.properties";
    private static final String QUERIES_FILE_PATH = "/personal/UniversityProjects/DBComponent/Queries.properties";
    private final Properties globalConfig = new Properties();
    private final Properties queriesConfig = new Properties();
    private PoolManager poolManager;

    public DBComponent() throws IOException {
        loadConfig();
        loadQueries();
    }

    public DBComponent(String dbName) throws IOException, SQLException, ClassNotFoundException {
        loadConfig();
        loadQueries();
        initializeDatabase(dbName);
    }

    private void loadConfig() throws IOException {
        try (InputStream input = getClass().getResourceAsStream(CONFIG_FILE_PATH)) {
            if (input == null) {
                throw new IOException("Config.properties file not found.");
            }
            globalConfig.load(input);
        }
    }

    private void loadQueries() throws IOException {
        try (InputStream input = getClass().getResourceAsStream(QUERIES_FILE_PATH)) {
            if (input == null) {
                throw new IOException("Queries.properties file not found.");
            }
            queriesConfig.load(input);
            System.out.println("Queries loaded: " + queriesConfig);
        }
    }

    private Properties getDBConfig(String dbName) {
        Properties dbProps = new Properties();
        dbProps.setProperty("URL", globalConfig.getProperty(dbName + ".URL"));
        dbProps.setProperty("USER", globalConfig.getProperty(dbName + ".USER"));
        dbProps.setProperty("PASSWORD", globalConfig.getProperty(dbName + ".PASSWORD"));
        dbProps.setProperty("DATABASE", globalConfig.getProperty(dbName + ".DATABASE"));
        dbProps.setProperty("INITIAL_SIZE", globalConfig.getProperty("INITIAL_SIZE"));
        dbProps.setProperty("MAX_SIZE", globalConfig.getProperty("MAX_SIZE"));
        dbProps.setProperty("GROWTH_SIZE", globalConfig.getProperty("GROWTH_SIZE"));
        return dbProps;
    }

    private void initializeDatabase(String dbName) throws SQLException, ClassNotFoundException, IOException {
        if (poolManager == null) {
            Properties dbConfig = getDBConfig(dbName);
            System.out.println("DB Connected to Pool Successfully!");
            this.poolManager = new PoolManager(dbConfig);
        }
    }

    public void UseDatabase(String dbName) throws SQLException, ClassNotFoundException, IOException {
        if (poolManager != null) {
            poolManager.resetPool();
        }

        Properties dbConfig = getDBConfig(dbName);
        System.out.println("DB selected successfully!");
        this.poolManager = new PoolManager(dbConfig);
    }

    public Connection getConnection() throws SQLException, InterruptedException, ClassNotFoundException {
        if (poolManager == null) {
            throw new IllegalStateException("Database not selected. Call switchDatabase first.");
        }
        return poolManager.getConnection();
    }

    public void returnConnection(Connection connection) {
        if (poolManager != null) {
            poolManager.returnConnection(connection);
        }
    }

    public String getSentence(String schema, String queryName) {
        String key = schema + "." + queryName;
        if (!queriesConfig.containsKey(key)) {
            System.out.println("Key " + key + " not found");
            return null;
        }
        return queriesConfig.getProperty(key);
    }

    public String[] getParameters(String schema, String queryName) {
        String sentence = getSentence(schema, queryName);
        int paramCount = sentence.length() - sentence.replace("?", "").length();

        if (paramCount == 0) {
            return new String[0];
        }

        Scanner sc = new Scanner(System.in);
        String[] params = new String[paramCount];

        for (int i = 0; i < paramCount; i++) {
            System.out.print("Parameter " + (i + 1) + ": ");
            params[i] = sc.nextLine();
        }

        return params;
    }


    public ResultSet exe(String schema, String queryName) throws SQLException, InterruptedException, ClassNotFoundException {
        String sentence = getSentence(schema, queryName);
        if (sentence == null) {
            throw new SQLException("Query not found in properties file: " + schema + "." + queryName);
        }

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        stmt.executeQuery(sentence);
        returnConnection(con);
        return stmt.getResultSet();
    }


    public ResultSet exe(String schema, String queryName, String... params) throws SQLException, InterruptedException, ClassNotFoundException {
        String sentence = getSentence(schema, queryName);
        if (sentence == null) {
            throw new SQLException("Query not found in properties file: " + schema + "." + queryName);
        }

        Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(sentence);

        for (int i = 0; i < params.length; i++) {
            stmt.setString(i + 1, params[i]);
        }

        ResultSet resultSet = null;

        try {
            if (sentence.trim().toUpperCase().startsWith("SELECT")) {
                resultSet = stmt.executeQuery();
            } else {
                int affectedRows = stmt.executeUpdate();
                System.out.println("Rows affected: " + affectedRows);
            }
        } finally {
            returnConnection(con);
        }

        return resultSet;
    }


    public void printTable(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            System.out.printf("%-20s", metaData.getColumnName(i));
        }
        System.out.println();

        for (int i = 1; i <= columnCount; i++) {
            System.out.print("--------------------");
        }
        System.out.println();

        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-20s", resultSet.getObject(i));
            }
            System.out.println();
        }
    }


}
