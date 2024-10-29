package personal.UniversityProjects.ConnectionPool;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

public class Pool {

    private static Pool instance;
    private static final String CONFIG_PATH = "C:\\\\Users\\\\jjmel\\\\eclipse-workspace\\\\JavaCourse\\\\src\\\\personal\\\\UniversityProjects\\\\ProjectThreads\\\\Connection.properties\"";

    private int INITIAL_SIZE;
    private int MAX_SIZE;
    private int GROWTH_SIZE;
    private int CURRENT_SIZE;
    private String URL, USER, PASSWORD, DATABASE;
    private LinkedList<Connection> pool;
    private Cnn con;

    private Pool(Properties prop) throws SQLException, ClassNotFoundException {
        this.INITIAL_SIZE = Integer.parseInt(prop.getProperty("INITIAL_SIZE"));
        this.MAX_SIZE = Integer.parseInt(prop.getProperty("MAX_SIZE"));
        this.GROWTH_SIZE = Integer.parseInt(prop.getProperty("GROWTH_SIZE"));
        this.CURRENT_SIZE = INITIAL_SIZE;
        this.URL = prop.getProperty("URL");
        this.USER = prop.getProperty("USER");
        this.PASSWORD = prop.getProperty("PASSWORD");
        this.DATABASE = prop.getProperty("DATABASE");

        this.pool = new LinkedList<>();
        for (int i = 0; i < INITIAL_SIZE; i++) {
            pool.add(con.createConnection());
        }

    }

    public int getINITIAL_SIZE() {
        return INITIAL_SIZE;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public int getGROWTH_SIZE() {
        return GROWTH_SIZE;
    }

    public int getCURRENT_SIZE() {
        return CURRENT_SIZE;
    }

    public void setCURRENT_SIZE(int newSize) {
        CURRENT_SIZE = newSize;
    }

    public String getURL() {
        return URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getDATABASE() {
        return DATABASE;
    }

    public LinkedList<Connection> getPool() {
        return pool;
    }

    public static Pool getInstance() throws IOException, SQLException, ClassNotFoundException {
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


}
