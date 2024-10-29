package personal.UniversityProjects.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;

public class MyThreads extends Thread {

    private PoolManager poolManager;

    public MyThreads(PoolManager poolManager) {
        this.poolManager = poolManager;
    }

    @Override
    public void run() {
        Cnn connection = null;
        try {
            connection = new Cnn(poolManager.getPool()); // Create a new Cnn instance
            Connection conn = connection.getConnection();
            ResultSet rs = connection.exeQuery("SELECT * FROM prod");
            rs.close();
            connection.returnConnection(); // Return the connection
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
