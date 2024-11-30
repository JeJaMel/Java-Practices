package personal.UniversityProjects.OSProject;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ProcessAlgorithm algorithm = new ProcessAlgorithm("src/personal/UniversityProjects/OSProject/data.csv");

        long startTime = System.currentTimeMillis();
        algorithm.FirstInFirstOut();
        algorithm.LastInFirstOut();
        algorithm.RoundRobin();
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }

}