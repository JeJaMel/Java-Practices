package personal.UniversityProjects.ConnectionPool;

import java.sql.*;

public class Cnn {
    private Connection connection;
    private final Pool pool;

    public Cnn(Pool pool) throws SQLException, ClassNotFoundException {
        this.pool = pool;
        this.connection = null;
    }

    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(pool.getDATABASE());

        Connection c = DriverManager.getConnection(pool.getURL(), pool.getUSER(), pool.getPASSWORD());
        System.out.println("Connection created = " + c);
        return c;
    }

}
