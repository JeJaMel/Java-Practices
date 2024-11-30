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
    private int quantum;

    public ProcessAlgorithm(String filePath) {
        FILE_PATH = filePath;
        loadData();
    }

    private void loadData() {
        processes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            // Leer el quantum en la primera línea
            line = br.readLine();
            if (line != null && line.startsWith("Quantum=")) {
                quantum = Integer.parseInt(line.split("=")[1].trim());
            } else {
                throw new IllegalArgumentException("Quantum value missing or malformed in the input file.");
            }

            // Leer las tareas (líneas restantes)
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

            // Separar tiempos iniciales y de ejecución
            initialTimeList = getInitialTime(processes);
            executionTimeList = getExecutionTime(processes);

            // Validar tamaños
            if (initialTimeList.size() != executionTimeList.size()) {
                throw new IllegalStateException("Initial time list and execution time list sizes do not match.");
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
            taskList.add(new Task(i , initialTimeList.get(i), executionTimeList.get(i)));
        }
        return taskList;
    }

    public void FirstInFirstOut() {



    }

    public void LastInFirstOut() {

    }

    public void RoundRobin() {
        LinkedList<Task> taskList = createTaskList(); // Tareas en general
        LinkedList<Task> completedTasks = new LinkedList<>(); // Tareas completadas
        LinkedList<Task> waitingTasks = new LinkedList<>(); // Tareas esperando en cola
        LinkedList<Task> executingTask = new LinkedList<>();// Tarea ejecutandose en este momento
        int time = 0;




        // Imprimir resultados
        System.out.println("\nTareas completadas:");
        for (Task task : completedTasks) {
            System.out.println(task);
        }
    }

    public int getQuantum() {
        return quantum;
    }
}
