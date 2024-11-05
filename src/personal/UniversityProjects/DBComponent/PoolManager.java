package personal.UniversityProjects.DBComponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolManager {

    private final Pool pool;

    public PoolManager() throws IOException, SQLException, ClassNotFoundException {
        this.pool = Pool.getInstance();
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException, InterruptedException {
        synchronized (pool) {
            if (!pool.getPool().isEmpty()) {
                return pool.getPool().removeFirst();
            }

            if (pool.getCURRENT_SIZE() < pool.getMAX_SIZE()) {
                for (int i = 0; i < pool.getGROWTH_SIZE(); i++) {
                    Connection conn = new Cnn(pool).createConnection();
                    pool.getPool().add(conn);
                }
                pool.setCURRENT_SIZE(pool.getCURRENT_SIZE() + pool.getGROWTH_SIZE());
                System.out.println("Added " + pool.getGROWTH_SIZE() + " connections to the pool. Current size: " + pool.getCURRENT_SIZE());
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
