package personal.UniversityProjects.OSProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class ProcessAlgorithm {

    private final String FILE_PATH;
    private ArrayList<String> idList;
    private ArrayList<Integer> initialTimeList;
    private ArrayList<Integer> executionTimeList;
    private int quantum;

    public ProcessAlgorithm(String filePath) {
        FILE_PATH = filePath;
        loadData();
    }

    private void loadData() {
        ArrayList<Integer> processes = new ArrayList<>();
        ArrayList<String> tempIdList = new ArrayList<>();

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

                if (values.length >= 3) { // Asegurarnos de que hay al menos 3 valores
                    tempIdList.add(values[0].trim()); // Guardar el primer elemento en idList

                    // Intentar convertir los otros dos valores a enteros y agregarlos a processes
                    try {
                        processes.add(Integer.parseInt(values[1].trim()));
                        processes.add(Integer.parseInt(values[2].trim()));
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format in line: " + line);
                    }
                } else {
                    System.err.println("Invalid format, skipping line: " + line);
                }
            }

            initialTimeList = getInitialTime(processes);
            executionTimeList = getExecutionTime(processes);
            idList = getId(tempIdList);

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

    private ArrayList<String> getId(ArrayList<String> idList) {
        ArrayList<String> newIdList = new ArrayList<>();
        for (String s : idList) {
            newIdList.add(s.trim());
        }
        return newIdList;
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
            taskList.add(new Task(idList.get(i), initialTimeList.get(i), executionTimeList.get(i)));
        }
        return taskList;
    }

    public void FirstInFirstOut() {
        LinkedList<Task> taskList = createTaskList();
        LinkedList<Task> completedTasks = new LinkedList<>();
        int time = getFirstTime(taskList);

        while (!taskList.isEmpty()) {
            Iterator<Task> iterator = taskList.iterator();
            boolean restarted = false; // bandera para saber si debemos reiniciar el bucle

            while (iterator.hasNext()) {
                Task task = iterator.next();  // Obtener la siguiente tarea

                if (task.getTi() <= time) {
                    while (task.getTd() > 0) {
                        time++;
                        task.setTd(task.getTd() - 1); // Reducir el tiempo de ejecución restante
                    }

                    getValues(task, time, completedTasks);
                    iterator.remove();

                    restarted = true;
                    break;
                }
            }

            if (restarted) {
                continue; // Reinicia el ciclo desde el principio
            }
        }

        printTaskResults(completedTasks);

    }



    public void LastInFirstOut() {
        LinkedList<Task> taskList = createTaskList();
        LinkedList<Task> completedTasks = new LinkedList<>();
        int time = getFirstTime(taskList);

        while (!taskList.isEmpty()) {
            // Usamos un Iterator para recorrer la lista desde el final
            Iterator<Task> iterator = taskList.descendingIterator();
            boolean restarted = false; // bandera para saber si debemos reiniciar el bucle

            while (iterator.hasNext()) {
                Task task = iterator.next();  // Obtener la siguiente tarea desde el final

                if (task.getTi() <= time) {
                    while (task.getTd() > 0) {
                        time++;
                        task.setTd(task.getTd() - 1); // Reducir el tiempo de ejecución restante
                    }

                    getValues(task, time, completedTasks);
                    iterator.remove(); // Eliminar la tarea procesada

                    restarted = true;
                    break; // Salir del while y reiniciar el ciclo desde el final
                }
            }

            if (restarted) {
                continue; // Reinicia el ciclo desde el final
            }
        }

        printTaskResults(completedTasks);
    }

    public void RoundRobin() {
        LinkedList<Task> taskList = createTaskList(); // Tareas iniciales
        LinkedList<Task> completedTasks = new LinkedList<>(); // Tareas completadas
        LinkedList<Task> waitingTasks = new LinkedList<>(); // Cola de espera
        Task executingTask = null; // Tarea en ejecución
        LinkedList<Task> toRemove = new LinkedList<>(); // Tareas a eliminar de taskList
        int time = 0; // Tiempo inicial

        while (!taskList.isEmpty() || !waitingTasks.isEmpty() || executingTask != null) {
            // Revisar si alguna tarea llega en este tiempo
            for (Task task : taskList) {
                if (task.getTi() == time) {
                    waitingTasks.add(task); // Agregar a la cola de espera
                    toRemove.add(task); // Marcar para eliminar
                }
            }
            taskList.removeAll(toRemove); // Limpiar las tareas ya procesadas

            // Si no hay tarea ejecutándose, tomar la siguiente de la cola de espera
            if (executingTask == null && !waitingTasks.isEmpty()) {
                executingTask = waitingTasks.pollFirst();
            }

            // Ejecutar la tarea actual usando un bucle for para manejar el quantum
            if (executingTask != null) {
                for (int i = 0; i < quantum; i++) {
                    executingTask.setTd(executingTask.getTd() - 1); // Reducir el tiempo restante en 1
                    time++; // Incrementar tiempo en cada iteración

                    // Revisar si alguna tarea llega mientras se ejecuta el quantum
                    for (Task task : taskList) {
                        if (task.getTi() == time) {
                            waitingTasks.add(task); // Agregar a la cola de espera
                            toRemove.add(task); // Marcar para eliminar
                        }
                    }
                    taskList.removeAll(toRemove); // Limpiar tareas recién procesadas

                    // Si la tarea se completa durante el quantum
                    if (executingTask.getTd() <= 0) {
                        getValues(executingTask, time, completedTasks); // Registrar tiempo de finalización
                        executingTask = null;
                        break;
                    }
                }

                // Si el quantum termina y la tarea no se completó
                if (executingTask != null && executingTask.getTd() > 0) {
                    waitingTasks.add(executingTask); // Volver a la cola
                    executingTask = null; // Liberar la tarea actual
                }
            } else {
                time++; // Incrementar tiempo si no hay tarea ejecutándose
            }
        }

       printTaskResults(completedTasks);
    }

    private int getFirstTime(LinkedList<Task> taskList){
        int newTime = 0;
        Task minTask = taskList.stream()
                .min(Comparator.comparingInt(Task::getTi)) // Ordena por TI y obtiene el menor
                .orElse(null);

        if (minTask != null) {
            newTime = minTask.getTi();
        }
        return newTime;
    }

    private void getValues(Task currentTask, int time, LinkedList<Task> completedTasks){
        currentTask.setTf(time); // Tiempo de finalización
        currentTask.setT(currentTask.getTf() - currentTask.getTi()); // Turnaround time
        currentTask.setE(currentTask.getT() - currentTask.originalTd); // Tiempo de espera
        currentTask.setI((double) currentTask.originalTd / currentTask.getT()); // Índice de penalización
        completedTasks.add(currentTask); // Añadir a la lista de completadas
    }

    private void calculateAverages(LinkedList<Task> completedTasks) {
        if (completedTasks.isEmpty()) {
            System.out.println("No hay tareas completadas para calcular promedios.");
            return;
        }

        double totatT = 0; // Suma de tiempos totales
        double totalE = 0; // Suma de tiempos de espera
        double totalI = 0; // Suma de índices de penalización

        for (Task task : completedTasks) {
            totatT += task.getT();
            totalE += task.getE(); // Sumar tiempos de espera
            totalI += task.getI(); // Sumar índices de servicio
        }

        double averageT = totatT / completedTasks.size(); // Promedio de tiempo total
        double averageE = totalE / completedTasks.size(); // Promedio de tiempos de espera
        double averageI = totalI / completedTasks.size(); // Promedio de índices de penalización

        System.out.printf("| Promedio de tiempo total (E): %-18.3f |\n", averageT);
        System.out.printf("| Promedio de tiempos de espera (E): %-13.3f |\n", averageE);
        System.out.printf("| Promedio de índices de servicio (I): %-11.3f |\n", averageI);
    }

    private void printTaskResults(LinkedList<Task> completedTasks) {
        System.out.println("\nTareas completadas:");
        System.out.println("=".repeat(52));

        System.out.printf("| %-4s | %-4s | %-4s | %-4s | %-4s | %-4s | %-6s |%n",
                "ID", "TI", "TD", "TF", "T", "E", "I");
        System.out.println("=".repeat(52));

        for (Task task : completedTasks) {
            System.out.println(task);
        }
        System.out.println("=".repeat(52));

        calculateAverages(completedTasks);
        System.out.println("=".repeat(52));
    }



}
