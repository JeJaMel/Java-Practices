package personal.UniversityProjects.ConnectionPool;

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

//    public ResultSet exeQuery(String query) throws SQLException {
//        if (connection == null || connection.isClosed()) {
//            throw new SQLException("No connection available. Please call toConnect first.");
//        }
//        Statement stmt = connection.createStatement();
//        System.out.println("Executing query: " + query);
//        return stmt.executeQuery(query);
//    }

}
