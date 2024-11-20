package personal.UniversityProjects.OSProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessAlgorithm {

    private String FILE_PATH;

    public ProcessAlgorithm(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }

    public ArrayList<Integer> readInput() {
        ArrayList<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    try {
                        list.add(Integer.parseInt(value.trim()));
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format: " + value);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return list;
    }

    public int getQuantum() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = br.readLine();
            return Integer.parseInt(line.substring(line.indexOf("'") + 1, line.lastIndexOf("'")).trim());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return -1;
        }
    }


    public ArrayList<Integer> getInitialTime(ArrayList<Integer> list) {
        ArrayList<Integer> initialTimeList = new ArrayList<>();

        for (int i = 0; i < list.size(); i += 2) {
            initialTimeList.add(list.get(i));
        }

        return initialTimeList;
    }

    public ArrayList<Integer> getExecutionTIme(ArrayList<Integer> list) {
        ArrayList<Integer> executionTimeList = new ArrayList<>();
        for (int i = 1; i < list.size(); i += 2) {
            executionTimeList.add(list.get(i));
        }
        return executionTimeList;
    }

    public void FirstInFirstOut(ArrayList<Integer> initialTimeList, ArrayList<Integer> executionTimeList) {

    }

    public void LastInFirstOut(ArrayList<Integer> initialTimeList, ArrayList<Integer> executionTimeList) {

    }

    public void RoundRobin(ArrayList<Integer> initialTimeList, ArrayList<Integer> executionTimeList) {

    }

}
