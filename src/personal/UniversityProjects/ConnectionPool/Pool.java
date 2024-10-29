package personal.UniversityProjects.ConnectionPool;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Pool {

    private static Pool instance;
    private static final String CONFIG_PATH = "C:\\\\Users\\\\jjmel\\\\eclipse-workspace\\\\JavaCourse\\\\src\\\\personal\\\\UniversityProjects\\\\ProjectThreads\\\\Connection.properties\"";

    private int INITIAL_SIZE;
    private int MAX_SIZE;
    private int GROWTH_SIZE;
    private String URL, USER, PASSWORD, DATABASE;

    private Pool(Properties prop) {
        this.INITIAL_SIZE = Integer.parseInt(prop.getProperty("INITIAL_SIZE"));
        this.MAX_SIZE = Integer.parseInt(prop.getProperty("MAX_SIZE"));
        this.GROWTH_SIZE = Integer.parseInt(prop.getProperty("GROWTH_SIZE"));
        this.URL = prop.getProperty("URL");
        this.USER = prop.getProperty("USER");
        this.PASSWORD = prop.getProperty("PASSWORD");
        this.DATABASE = prop.getProperty("DATABASE");
    }

    public static Pool getInstance() throws IOException {
        if (instance == null) {
            Properties props = loadProps(CONFIG_PATH);
            instance = new Pool(props);
        }
        return instance;
    }

    private static Properties loadProps(String configPath) throws IOException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(configPath)) {
            props.load(fis);
        }
        return props;
    }

    private void initializeConnections() {

    }
}
