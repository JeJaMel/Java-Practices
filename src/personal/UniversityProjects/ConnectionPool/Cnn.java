package personal.UniversityProjects.ConnectionPool;

import java.sql.*;

public class Cnn {
    private Connection connection;
    private final Pool pool;

    public Cnn(Pool pool) throws SQLException, ClassNotFoundException {
        this.pool = pool;
        this.connection = createConnection();
    }

    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(pool.getDATABASE());
        System.out.println("Connection has been created");
        return DriverManager.getConnection(pool.getURL(), pool.getUSER(), pool.getPASSWORD());
    }

    public ResultSet exeQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        System.out.println("Completed");
        return stmt.executeQuery(query);
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        synchronized (pool) {
            if (pool.getPool().isEmpty() && pool.getCURRENT_SIZE() < pool.getMAX_SIZE()) {
                int newConnections = Math.min(pool.getGROWTH_SIZE(), pool.getMAX_SIZE() - pool.getCURRENT_SIZE());
                for (int i = 0; i < newConnections; i++) {
                    pool.getPool().add(createConnection());
                }
                pool.setCURRENT_SIZE(pool.getCURRENT_SIZE() + newConnections);
                System.out.println("Pool Size increased to: " + pool.getCURRENT_SIZE());
            }
            try {
                while (pool.getPool().isEmpty()) {
                    pool.wait();
                }
            } catch (InterruptedException e) {
                throw new SQLException("Error waiting...", e);
            }
            return pool.getPool().poll();
        }
    }

    public void returnConnection() {
        if (this.connection != null) {
            synchronized (pool) {
                pool.getPool().add(this.connection);
                pool.notifyAll();
            }
            this.connection = null;
        }
    }
}
