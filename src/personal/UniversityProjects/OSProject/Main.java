package personal.UniversityProjects.OSProject;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ProcessAlgorithm algorithm = new ProcessAlgorithm("src/personal/UniversityProjects/OSProject/data.csv");

        long startTime = System.currentTimeMillis();
        long startTimeFIFO = System.currentTimeMillis();
        algorithm.FirstInFirstOut();
        long endTimeFIFO = System.currentTimeMillis();
        System.out.println("FirstInFirstOut Time: " + (endTimeFIFO - startTimeFIFO) + "ms");

        long startTimeLIFO = System.currentTimeMillis();
        algorithm.LastInFirstOut();
        long endTimeLIFO = System.currentTimeMillis();
        System.out.println("LastInFirstOut Time: " + (endTimeLIFO - startTimeLIFO) + "ms");

        long startTimeRR = System.currentTimeMillis();
        algorithm.RoundRobin();
        long endTimeRR = System.currentTimeMillis();
        System.out.println("RoundRobin Time: " + (endTimeRR - startTimeRR) + "ms");

        long endTime = System.currentTimeMillis();
        System.out.println("total Time: " + (endTime - startTime) + "ms");

    }

}