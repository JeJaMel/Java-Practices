package personal.UniversityProjects.ConnectionPool;

import java.sql.ResultSet;

public class MyThreads extends Thread {

    private Cnn connection;

    @Override
    public void run() {
        try {
            connection.getConnection();
            ResultSet rs = connection.exeQuery("SELECT * FROM prod");
            rs.close();
            connection.returnConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
