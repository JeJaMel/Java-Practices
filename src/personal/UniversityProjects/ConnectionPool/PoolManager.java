package personal.UniversityProjects.ConnectionPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolManager {

    private final Pool pool;

    public PoolManager() throws IOException, SQLException, ClassNotFoundException {
        this.pool = Pool.getInstance();
    }

    public Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
        Cnn connection = new Cnn(pool);
        return connection.getConnection();
    }

    public void returnConnection(Cnn connection) {
        connection.returnConnection();
    }

    public Pool getPool() {
        return pool;
    }

}
