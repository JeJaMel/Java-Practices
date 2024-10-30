package personal.UniversityProjects.ConnectionPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolManager {

    private final Pool pool;

    public PoolManager() throws IOException, SQLException, ClassNotFoundException {
        this.pool = Pool.getInstance();
    }

    public Connection getConnection() throws IOException, SQLException, ClassNotFoundException, InterruptedException {
        synchronized (pool) {
            if (!pool.getPool().isEmpty()) {
                return pool.getPool().removeFirst();
            }

            if (pool.getCURRENT_SIZE() < pool.getMAX_SIZE()) {
                Connection conn = new Cnn(pool).createConnection();
                pool.setCURRENT_SIZE(pool.getCURRENT_SIZE() + 1);
                return conn;
            }

            while (pool.getPool().isEmpty()) {
                pool.wait();
            }
            return pool.getPool().removeFirst();
        }
    }

    public void returnConnection(Connection connection) {
        synchronized (pool) {
            pool.getPool().add(connection);
            pool.notifyAll();
        }
    }

}
