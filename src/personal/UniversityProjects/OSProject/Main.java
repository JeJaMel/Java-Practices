package personal.UniversityProjects.OSProject;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        ProcessAlgorithm algorithm = new ProcessAlgorithm("src/personal/UniversityProjects/OSProject/data.csv");

        ArrayList<Integer> list = algorithm.readInput();

        System.out.println(list);

        ArrayList<Integer> initialList = new ArrayList<>();
        initialList = algorithm.getInitialTime(list);
        System.out.println(initialList);

        ArrayList<Integer> executionList = new ArrayList<>();
        executionList = algorithm.getExecutionTIme(list);
        System.out.println(executionList);

        int a = algorithm.getQuantum();

    }

}
