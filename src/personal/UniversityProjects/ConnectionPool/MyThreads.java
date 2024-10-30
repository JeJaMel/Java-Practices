package personal.UniversityProjects.ConnectionPool;

import java.sql.ResultSet;
import java.sql.*;

public class MyThreads extends Thread {

    private final PoolManager poolManager;
    private static int successfulCounter;
    private static int failedCounter;

    public MyThreads(PoolManager poolManager) {
        this.poolManager = poolManager;
    }

    public static int getSuccessfulCounter() {
        return successfulCounter;
    }

    public static int getFailedCounter() {
        return failedCounter;
    }

    public static synchronized void incrementSuccessfulCounter() {
        successfulCounter++;
    }

    public static synchronized void incrementFailedCounter() {
        failedCounter++;
    }


    @Override
    public void run() {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = poolManager.getConnection();
            Statement stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM prod");
            incrementSuccessfulCounter();
        } catch (Exception e) {
            e.printStackTrace();
            incrementFailedCounter();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (connection != null) poolManager.returnConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

