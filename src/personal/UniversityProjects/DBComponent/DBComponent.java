package personal.UniversityProjects.DBComponent;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBComponent {

    private static final String CONFIG_FILE_PATH = "/personal/UniversityProjects/DBComponent/Config.properties";
    private final Properties globalConfig = new Properties();
    private final Properties connectionProperties = new Properties();
    private PoolManager poolManager;

    public DBComponent() throws IOException {
        loadConfig();
    }

    private void loadConfig() throws IOException {
        try (InputStream input = getClass().getResourceAsStream(CONFIG_FILE_PATH)) {
            if (input == null) {
                throw new IOException("Config.properties file not found.");
            }
            globalConfig.load(input);
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

    public void switchDatabase(String dbName) throws SQLException, ClassNotFoundException, IOException {
        if (poolManager != null) {
            poolManager.resetPool();
        }

        Properties dbConfig = getDBConfig(dbName);
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
}
