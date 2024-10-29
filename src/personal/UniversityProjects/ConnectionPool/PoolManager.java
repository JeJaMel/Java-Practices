package personal.UniversityProjects.ConnectionPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolManager {

    private Pool pool;
    private Cnn connection;

    public PoolManager() throws IOException, SQLException, ClassNotFoundException {
        pool = Pool.getInstance();
    }

    public Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
        return connection.getConnection();
    }

    public void returnConnection(Connection conn) {
        connection.returnConnection();
    }

}
