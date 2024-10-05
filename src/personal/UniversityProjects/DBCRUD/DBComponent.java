package personal.UniversityProjects.DBCRUD;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBComponent {

    private final Properties connectionProperties = new Properties();
    private final Properties sentecesProperties = new Properties();


    public DBComponent(String connectionFilePath, String sentencesFilePath) {
        try {
            connectionProperties.load(new FileInputStream(connectionFilePath));
            sentecesProperties.load(new FileInputStream(sentencesFilePath));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public String getURL() {
        return connectionProperties.getProperty("URL");
    }

    public String getUser() {
        return connectionProperties.getProperty("User");
    }

    public String getPassword() {
        return connectionProperties.getProperty("Password");
    }

    private Connection getCnn() throws ClassNotFoundException, SQLException {
        Connection con;
        Class.forName(connectionProperties.getProperty("Database"));
        con = DriverManager.getConnection(getURL(), getUser(), getPassword());
        System.out.println("Connected Successfully! ");
        return con;
    }

    private String getSentence(String schema, String queryName) {
        String key = schema + "." + queryName;
        if (!sentecesProperties.containsKey(key)) {
            System.out.println("Key " + key + " not found");
            return null;
        }
        return sentecesProperties.getProperty(key);
    }


    private void printQuery(ResultSet rs) {
        try {
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exe(String schema, String queryName, String[] params) {
        try {
            String sentence = getSentence(schema, queryName);
            sentence = sentence.replace("?", params[0]);
            Connection con = getCnn();
            Statement stmt = con.createStatement();
            stmt.executeQuery(sentence);
            ResultSet rs = stmt.getResultSet();
            printQuery(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
