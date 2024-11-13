package personal.UniversityProjects.DBComponent;

import java.sql.*;

public class Cnn {
    private final Pool pool;

    public Cnn(Pool pool) {
        this.pool = pool;
    }

    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(pool.getDATABASE());
        Connection c = DriverManager.getConnection(pool.getURL(), pool.getUSER(), pool.getPASSWORD());
        System.out.println("Connection created = " + c);
        return c;
    }

}
