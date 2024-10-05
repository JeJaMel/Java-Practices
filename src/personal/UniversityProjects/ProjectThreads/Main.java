package personal.UniversityProjects.ProjectThreads;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        try {
            long startTime = System.currentTimeMillis();
            int threadNumber = 100000;
            MyThreads[] threads = new MyThreads[threadNumber];

            for (int i = 1; i <= threadNumber; i++) {
                threads[i - 1] = new MyThreads();
                threads[i - 1].setName("Thread " + i);
                threads[i - 1].start();
                System.out.println("Thread " + i + " started");
            }

            for (int i = 0; i < threadNumber; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Successful connections: " + MyThreads.getSuccessfulCounter());
            System.out.println("Failed connections: " + MyThreads.getFailedCounter());
            System.out.println("Time taken: " + (endTime - startTime) + " ms");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
