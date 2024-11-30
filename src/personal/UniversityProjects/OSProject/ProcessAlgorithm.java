package personal.UniversityProjects.OSProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class ProcessAlgorithm {

    private final String FILE_PATH;
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
        LinkedList<Task> executingTask = new LinkedList<>(); // Tarea ejecutándose en este momento
        LinkedList<Task> toRemove = new LinkedList<>(); // Tarea que se eliminará de taskList
        int time = 0;

        while (!taskList.isEmpty() || !waitingTasks.isEmpty() || !executingTask.isEmpty()) {
            // Ciclo para avanzar dentro de un quantum
            for (int i = 0; i < quantum; i++) {
                // Si executingTask está vacía, mover la primera tarea de waitingTasks a executingTask
                if (executingTask.isEmpty() && !waitingTasks.isEmpty()) {
                    Task nextTask = waitingTasks.poll();  // Sacar de la cabeza de la cola de espera
                    executingTask.add(nextTask);  // Mover a executingTask
                    System.out.println("Tarea " + nextTask.getId() + " comenzó a ejecutarse en el tiempo " + time);
                }

                // Verificar si hay una tarea en ejecución
                if (!executingTask.isEmpty()) {
                    Task currentTask = executingTask.peek(); // Obtener la tarea que se está ejecutando actualmente
                    currentTask.setTd(currentTask.getTd() - 1); // Reducir el tiempo de ejecución
                    System.out.println("Tiempo " + time + ": Ejecutando tarea " + currentTask.getId() + " con td=" + currentTask.getTd());

                    // Si el tiempo de ejecución llega a 0, mover a completadas
                    if (currentTask.getTd() <= 0) {
                        // Calcular métricas cuando la tarea está completada
                        currentTask.setTf(time); // Tiempo de finalización
                        currentTask.setT(currentTask.getTf() - currentTask.getTi()); // Turnaround time
                        currentTask.setE(currentTask.getT() - currentTask.originalTd); // Tiempo de espera
                        currentTask.setI((double) currentTask.originalTd / currentTask.getT()); // Índice de penalización
                        completedTasks.add(currentTask); // Añadir a la lista de completadas


                        executingTask.poll(); // Remover la tarea de executingTask
                    }
                }

                // Mover nuevas tareas de taskList a waitingTasks o executingTask según corresponda
                for (Task task : taskList) {
                    if (task.getTi() == time) {
                        if (executingTask.isEmpty()) {
                            executingTask.add(task); // Mover a tarea en ejecución si no hay ninguna
                            toRemove.add(task);
                            System.out.println("Tarea " + task.getId() + " comenzó a ejecutarse en el tiempo " + time);
                        } else {
                            waitingTasks.add(task); // Si ya hay una en ejecución, mover a la cola de espera
                            toRemove.add(task);
                            System.out.println("Tarea " + task.getId() + " añadida a la cola de espera en el tiempo " + time);
                        }
                    }
                }

                // Eliminar tareas de taskList que ya han sido movidas a espera o ejecución
                taskList.removeAll(toRemove);
                toRemove.clear();

                // Si el quantum ha llegado al límite, mover la tarea actual al final de waitingTasks
                if (i == quantum - 1 && !executingTask.isEmpty()) {
                    Task executingTaskCurrent = executingTask.poll();  // Sacar de executingTask
                    waitingTasks.add(executingTaskCurrent);  // Mover la tarea al final de waitingTasks
                    System.out.println("Tarea " + executingTaskCurrent.getId() + " movida al final de la cola de espera en el tiempo " + time);

                    // Mover la siguiente tarea a executingTask si hay alguna en waitingTasks
                    if (!waitingTasks.isEmpty()) {
                        Task nextTask = waitingTasks.poll();  // Sacar de la cabeza de la cola de espera
                        executingTask.add(nextTask);  // Mover a executingTask
                        System.out.println("Tarea " + nextTask.getId() + " comenzó a ejecutarse en el tiempo " + time);
                    }
                }

                // Avanzar el tiempo
                time++;
            }
        }

        // Imprimir resultados
        System.out.println("\nTareas completadas:");
        for (Task task : completedTasks) {
            System.out.println(task);
        }
    }



}
