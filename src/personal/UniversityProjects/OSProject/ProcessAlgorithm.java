package personal.UniversityProjects.OSProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class ProcessAlgorithm {

    private String FILE_PATH;
    private ArrayList<Integer> processes;
    private ArrayList<Integer> initialTimeList;
    private ArrayList<Integer> executionTimeList;
    private LinkedList<Task> taskList;
    private int quantum;

    public ProcessAlgorithm(String filePath) {
        FILE_PATH = filePath;
        loadData();
        taskList = createTaskList();
    }

    private void loadData() {
        processes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            quantum = Integer.parseInt(br.readLine()
                    .substring(br.readLine().indexOf("'") + 1, br.readLine().lastIndexOf("'"))
                    .trim());

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    try {
                        processes.add(Integer.parseInt(value.trim()));
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format: " + value);
                    }
                }
            }

            initialTimeList = getInitialTime(processes);
            executionTimeList = getExecutionTime(processes);

            if (initialTimeList.size() != executionTimeList.size()) {
                System.out.println("Both, initial time and execution time must be the same");
                System.exit(0);
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing data: " + e.getMessage());
        }
    }

    private ArrayList<Integer> getInitialTime(ArrayList<Integer> list) {
        ArrayList<Integer> initialTimes = new ArrayList<>();
        for (int i = 0; i < list.size(); i += 2) {
            initialTimes.add(list.get(i));
        }
        return initialTimes;
    }

    private ArrayList<Integer> getExecutionTime(ArrayList<Integer> list) {
        ArrayList<Integer> executionTimes = new ArrayList<>();
        for (int i = 1; i < list.size(); i += 2) {
            executionTimes.add(list.get(i));
        }
        return executionTimes;
    }

    private LinkedList<Task> createTaskList() {
        LinkedList<Task> taskList = new LinkedList<>();
        for (int i = 0; i < initialTimeList.size(); i++) {
            taskList.add(new Task(initialTimeList.get(i), executionTimeList.get(i)));
        }
        return taskList;
    }

    public void FirstInFirstOut() {



    }

    public void LastInFirstOut() {

    }

    public void RoundRobin() {
        for (Task task : taskList) {

            task.setTf( + task.getTd());
            task.setT(task.getTf() - task.getTi());
            task.setE(task.getT() - task.getTd());
            task.setI((double) task.getTd() / task.getT());

        }
    }
}
