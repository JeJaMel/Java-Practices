package personal.UniversityProjects.OSProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

            //Read quantum at line 1
            line = br.readLine();
            if (line != null && line.startsWith("Quantum=")) {
                quantum = Integer.parseInt(line.split("=")[1].trim());
            } else {
                throw new IllegalArgumentException("Quantum value missing or malformed in the input file.");
            }

            //Read Task's
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length >= 3) {
                    tempIdList.add(values[0].trim());

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

            //set all the list's
            initialTimeList = getInitialTime(processes);
            executionTimeList = getExecutionTime(processes);
            idList = getId(tempIdList);

            if (initialTimeList.size() != executionTimeList.size()) {
                throw new IllegalStateException("Initial time list and execution time list sizes do not match.");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing data: " + e.getMessage());
        }
    }

    //Get an ArrayList with the id's
    private ArrayList<String> getId(ArrayList<String> idList) {
        ArrayList<String> newIdList = new ArrayList<>();
        for (String s : idList) {
            newIdList.add(s.trim());
        }
        return newIdList;
    }

    //get an ArrayList with the initial time
    private ArrayList<Integer> getInitialTime(ArrayList<Integer> list) {
        ArrayList<Integer> initialTimes = new ArrayList<>();
        for (int i = 0; i < list.size(); i += 2) {
            initialTimes.add(list.get(i));
        }
        return initialTimes;
    }

    //get an ArrayList with the execution time
    private ArrayList<Integer> getExecutionTime(ArrayList<Integer> list) {
        ArrayList<Integer> executionTimes = new ArrayList<>();
        for (int i = 1; i < list.size(); i += 2) {
            executionTimes.add(list.get(i));
        }
        return executionTimes;
    }

    //create the Linked list of type Task, with the values got from loadData method
    private LinkedList<Task> createTaskList() {
        LinkedList<Task> taskList = new LinkedList<>();
        for (int i = 0; i < initialTimeList.size(); i++) {
            taskList.add(new Task(idList.get(i), initialTimeList.get(i), executionTimeList.get(i)));
        }
        return taskList;
    }

    //Fifo process schedule
    public double firstInFirstOut() {
        LinkedList<Task> taskList = createTaskList();
        LinkedList<Task> completedTasks = new LinkedList<>();
        int time = getFirstTime(taskList);

        while (!taskList.isEmpty()) {
            Iterator<Task> iterator = taskList.iterator();
            time = process(completedTasks, time, iterator);
        }

        return printTaskResults(completedTasks);

    }

    //Lifo process schedule
    public double lastInFirstOut() {
        LinkedList<Task> taskList = createTaskList();
        LinkedList<Task> completedTasks = new LinkedList<>();
        int time = getFirstTime(taskList);

        while (!taskList.isEmpty()) {
            //as we want to use lifo, we use a descending iterator
            Iterator<Task> iterator = taskList.descendingIterator();
            time = process(completedTasks, time, iterator);
        }

        return printTaskResults(completedTasks);
    }

    //process uses a normal or a descending iterator depending on if you want to execute fifo or lifo
    private int process(LinkedList<Task> completedTasks, int time, Iterator<Task> iterator) {
        boolean restarted = false;
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getTi() <= time) {
                while (task.getTd() > 0) {
                    time++;
                    task.setTd(task.getTd() - 1); //simulate process the task
                }

                getValues(task, time, completedTasks);
                iterator.remove();

                restarted = true;
                break;
            }
        }

        if (restarted) {
            return time;
        }
        return time;
    }

    //get the lowest and first ti
    private int getFirstTime(LinkedList<Task> taskList) {
        int newTime = 0;
        Task minTask = taskList.stream()
                .min(Comparator.comparingInt(Task::getTi))
                .orElse(null);

        if (minTask != null) {
            newTime = minTask.getTi();
        }
        return newTime;
    }

    //Round Robin process schedule
    public double roundRobin() {
        LinkedList<Task> taskList = createTaskList();
        LinkedList<Task> completedTasks = new LinkedList<>();
        LinkedList<Task> waitingTasks = new LinkedList<>();
        Task executingTask = null;
        LinkedList<Task> toRemove = new LinkedList<>();
        int time = 0;

        while (!taskList.isEmpty() || !waitingTasks.isEmpty() || executingTask != null) {
            //get the lowest ti to add it to the waiting list queue
            for (Task task : taskList) {
                if (task.getTi() == time) {
                    waitingTasks.add(task);
                    toRemove.add(task);
                }
            }
            taskList.removeAll(toRemove);

            if (executingTask == null && !waitingTasks.isEmpty()) {
                executingTask = waitingTasks.pollFirst();
            }

            if (executingTask != null) {
                for (int i = 0; i < quantum; i++) {
                    executingTask.setTd(executingTask.getTd() - 1);
                    time++;

                    //check if any new task  comes during quantum period
                    for (Task task : taskList) {
                        if (task.getTi() == time) {
                            waitingTasks.add(task);
                            toRemove.add(task);
                        }
                    }
                    taskList.removeAll(toRemove);

                    //if task completed during quantum period
                    if (executingTask.getTd() <= 0) {
                        getValues(executingTask, time, completedTasks);
                        executingTask = null;
                        break;
                    }
                }

                //If the task still needs more time, it returns it to the waiting list queue.
                if (executingTask != null && executingTask.getTd() > 0) {
                    waitingTasks.add(executingTask); // Volver a la cola
                    executingTask = null; // Liberar la tarea actual
                }
            } else {
                time++;
            }
        }

        return printTaskResults(completedTasks);
    }

    private void getValues(Task currentTask, int time, LinkedList<Task> completedTasks) {
        currentTask.setTf(time);
        currentTask.setT(currentTask.getTf() - currentTask.getTi());
        currentTask.setE(currentTask.getT() - currentTask.originalTd);
        currentTask.setI((double) currentTask.originalTd / currentTask.getT());
        completedTasks.add(currentTask);
    }

    private double calculateAverages(LinkedList<Task> completedTasks) {
        double totatT = 0;
        double totalE = 0;
        double totalI = 0;

        for (Task task : completedTasks) {
            totatT += task.getT();
            totalE += task.getE();
            totalI += task.getI();
        }

        //Get required averages
        double averageT = totatT / completedTasks.size();
        double averageE = totalE / completedTasks.size();
        double averageI = totalI / completedTasks.size();

        System.out.printf("| Promedio de tiempo total (T): %-18.3f |\n", averageT);
        System.out.printf("| Promedio de tiempos de espera (E): %-13.3f |\n", averageE);
        System.out.printf("| Promedio de índices de servicio (I): %-11.3f |\n", averageI);

        return averageT;
    }

    private double printTaskResults(LinkedList<Task> completedTasks) {
        System.out.println("\nTareas completadas:");
        System.out.println("=".repeat(52));

        System.out.printf("| %-4s | %-4s | %-4s | %-4s | %-4s | %-4s | %-6s |%n",
                "ID", "TI", "TD", "TF", "T", "E", "I");
        System.out.println("=".repeat(52));

        for (Task task : completedTasks) {
            System.out.println(task);
        }
        System.out.println("=".repeat(52));

        double averageT = calculateAverages(completedTasks);
        System.out.println("=".repeat(52));
        return averageT;
    }

    public void compareProcesses() {
        long startTimeFIFO = System.currentTimeMillis();
        double fifo = firstInFirstOut();
        long endTimeFIFO = System.currentTimeMillis();
        System.out.println("FirstInFirstOut Time: " + (endTimeFIFO - startTimeFIFO) + "ms");

        long startTimeLIFO = System.currentTimeMillis();
        double lifo = lastInFirstOut();
        long endTimeLIFO = System.currentTimeMillis();
        System.out.println("LastInFirstOut Time: " + (endTimeLIFO - startTimeLIFO) + "ms");

        long startTimeRR = System.currentTimeMillis();
        double roundRobin = roundRobin();
        long endTimeRR = System.currentTimeMillis();
        System.out.println("RoundRobin Time: " + (endTimeRR - startTimeRR) + "ms");

        List<AlgorithmTime> times = new ArrayList<>();
        times.add(new AlgorithmTime("FirstInFirstOut", fifo));
        times.add(new AlgorithmTime("LastInFirstOut", lifo));
        times.add(new AlgorithmTime("RoundRobin", roundRobin));

        times.sort(Comparator.comparingDouble(AlgorithmTime::getTime));

        System.out.println("=".repeat(52));
        System.out.println("Best processes based on average time:");
        System.out.println("=".repeat(52));

        for (AlgorithmTime time : times) {
            System.out.printf("| %-24s | %-19.3fms |%n", time.getName(), time.getTime());
        }

        System.out.println("=".repeat(52));

    }

}
