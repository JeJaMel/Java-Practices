package personal.UniversityProjects.ConnectionPool;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        long startTime = System.currentTimeMillis();
        List<MyThreads> threads = new ArrayList<>();

        try {
            for (int i = 0; i < 1000; i++) {
                PoolManager poolManager = new PoolManager();
                MyThreads client = new MyThreads(poolManager);
                client.setName("Client-" + i);
                client.start();
                threads.add(client);
            }

            for (MyThreads thread : threads) {
                thread.join();
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Successful connections: " + MyThreads.getSuccessfulCounter());
            System.out.println("Failed connections: " + MyThreads.getFailedCounter());
            System.out.println("Time taken: " + (endTime - startTime) + " ms");

        } catch (IOException | SQLException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

