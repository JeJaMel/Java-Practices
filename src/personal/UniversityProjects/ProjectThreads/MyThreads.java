package personal.UniversityProjects.ProjectThreads;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MyThreads extends Thread {

    private static int successfulCounter;
    private static int failedCounter;

    public static int getSuccessfulCounter() {
        return successfulCounter;
    }

    public static int getFailedCounter() {
        return failedCounter;
    }

    public static synchronized void incrementSuccessfulCounter() {
        successfulCounter++;
    }

    public static synchronized void incrementFailedCounter() {
        failedCounter++;
    }

    public Properties loadConnProperties() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("C:\\Users\\jjmel\\eclipse-workspace\\JavaCourse\\src\\personal\\UniversityProjects\\ProjectThreads\\Connection.properties"));
        return props;
    }

    private String getURL() throws IOException {
        return loadConnProperties().getProperty("URL");
    }

    private String getUser() throws IOException {
        return loadConnProperties().getProperty("User");
    }

    private String getPassword() throws IOException {
        return loadConnProperties().getProperty("Password");
    }

    private String getDatabase() throws IOException {
        return loadConnProperties().getProperty("Database");
    }

    @Override
    public void run() {
        try {
            Class.forName(getDatabase());
            Connection con;
            con = DriverManager.getConnection(getURL(), getUser(), getPassword());
            if (con != null) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM prod");
                rs.close();
                stmt.close();
                incrementSuccessfulCounter();
            }
            con.close();
        } catch (Exception e) {
            incrementFailedCounter();
            System.out.println(e);
        }
    }
}
