package personal.UniversityProjects.ConnectionPool;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        try {
            PoolManager poolManager = new PoolManager();

            for (int i = 0; i < 1; i++) {
                MyThreads client = new MyThreads(poolManager);
                client.setName("Client-" + i);
                client.start();
            }
        } catch (IOException | SQLException |
                 ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

