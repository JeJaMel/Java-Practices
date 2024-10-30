package personal.UniversityProjects.ConnectionPool;

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
                int connectionsToAdd = Math.min(pool.getGROWTH_SIZE(), pool.getMAX_SIZE() - pool.getCURRENT_SIZE());

                for (int i = 0; i < connectionsToAdd; i++) {
                    Connection conn = new Cnn(pool).createConnection();
                    pool.getPool().add(conn);
                }

                pool.setCURRENT_SIZE(pool.getCURRENT_SIZE() + connectionsToAdd);

                System.out.println("Added " + connectionsToAdd + " connections to the pool. Current size: " + pool.getCURRENT_SIZE());
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
