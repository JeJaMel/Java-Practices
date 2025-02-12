package personal.UniversityProjects.DBComponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

public class Pool {

    private static Pool instance;
    private final int MAX_SIZE;
    private final int GROWTH_SIZE;
    private int CURRENT_SIZE;
    private final String URL, USER, PASSWORD, DATABASE;
    private final LinkedList<Connection> pool;

    private Pool(Properties prop) throws SQLException, ClassNotFoundException {
        int INITIAL_SIZE = Integer.parseInt(prop.getProperty("INITIAL_SIZE"));
        this.MAX_SIZE = Integer.parseInt(prop.getProperty("MAX_SIZE"));
        this.GROWTH_SIZE = Integer.parseInt(prop.getProperty("GROWTH_SIZE"));
        this.CURRENT_SIZE = INITIAL_SIZE;
        this.URL = prop.getProperty("URL");
        this.USER = prop.getProperty("USER");
        this.PASSWORD = prop.getProperty("PASSWORD");
        this.DATABASE = prop.getProperty("DATABASE");

        this.pool = new LinkedList<>();

        for (int i = 0; i < INITIAL_SIZE; i++) {
            pool.add(createConnection());
        }
    }

    private Connection createConnection() throws ClassNotFoundException, SQLException {
        if (CURRENT_SIZE < MAX_SIZE) {
            return new Cnn(this).createConnection();
        }
        throw new SQLException("Reached maximum pool size.");
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

    public static Pool getInstance(Properties props) throws IOException, SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new Pool(props);
        }
        return instance;
    }

    private void closeAllConnections() {
        for (Connection conn : pool) {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
        pool.clear();
        CURRENT_SIZE = 0;
    }

    public static void resetInstance() {
        if (instance != null) {
            instance.closeAllConnections();
            instance = null;
        }
    }

}

