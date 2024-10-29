package personal.UniversityProjects.ConnectionPool;

public class Main {

    public static void main(String[] args) {
        try {
            PoolManager poolManager = new PoolManager();

            for (int i = 0; i < 100; i++) {
                MyThreads thread = new MyThreads();
                thread.start();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
