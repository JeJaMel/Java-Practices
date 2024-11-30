package personal.UniversityProjects.OSProject;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ProcessAlgorithm algorithm = new ProcessAlgorithm("src/personal/UniversityProjects/OSProject/data.csv");

        algorithm.RoundRobin();

    }

}