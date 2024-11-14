package personal.UniversityProjects.DBComponent;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, InterruptedException {

        boolean run = true;
        int option;
        DBComponent db = new DBComponent();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hi, welcome to the DBComponent test!");
        System.out.println("Please enter the name of the Db you want to connect...");
        String dbName = sc.nextLine();
        db.UseDatabase(dbName);

        while (run) {
            System.out.println(printMenu());
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {
                    System.out.println("Enter the schema:");
                    String schema = sc.nextLine();

                    System.out.println("Enter the query name:");
                    String queryName = sc.nextLine();

                    String sentence = db.getSentence(schema, queryName);

                    if (sentence == null) {
                        System.out.println("Error: Query not found in properties file: " + schema + "." + queryName);
                        break;
                    }

                    String[] params = db.getParameters(schema, queryName);

                    ResultSet rs = db.exe(schema, queryName, params);

                    if (rs != null) {
                        db.printTable(rs);
                    } else {
                        System.out.println("Query executed successfully!");
                    }
                    break;
                }

                case 2: {
                    System.out.println("Enter the name of the Db you want to connect...");
                    String name = sc.nextLine();
                    db.UseDatabase(name);
                    break;
                }

                case 3: {
                    System.out.println("Enter the schema:");
                    String schema = sc.nextLine();

                    System.out.println("Enter the query name:");
                    String queryName = sc.nextLine();

                    System.out.println("Enter the number of threads you want to test with:");
                    int numThreads = sc.nextInt();
                    sc.nextLine();

                    String sentence = db.getSentence(schema, queryName);

                    if (sentence == null) {
                        System.out.println("Error: Query not found in properties file: " + schema + "." + queryName);
                        break;
                    }

                    int paramCount = sentence.length() - sentence.replace("?", "").length();

                    if (paramCount > 0) {
                        System.out.println("Error: This query requires parameters. Please use a query without parameters for testing.");
                        break;
                    }

                    long startTime = System.currentTimeMillis();
                    var threads = new ArrayList<MyThreads>();

                    for (int i = 0; i < numThreads; i++) {
                        MyThreads thread = new MyThreads(db, schema, queryName);
                        thread.start();
                        threads.add(thread);
                    }

                    for (MyThreads thread : threads) {
                        thread.join();
                    }

                    long endTime = System.currentTimeMillis();
                    System.out.println("=".repeat(35));
                    System.out.println("Successful connections: " + MyThreads.getSuccessfulCounter());
                    System.out.println("Failed connections: " + MyThreads.getFailedCounter());
                    System.out.println("Time taken: " + (endTime - startTime) + " ms");
                    System.out.println("=".repeat(35));
                    MyThreads.resetCounter();
                    break;
                }


                case 4:
                    run = false;
                    break;

                default:
                    System.out.println("Please enter a valid option!");
                    break;
            }
        }


    }

    public static String printMenu() {
        return """
                    \nPlease select an option below:
                1. Execute Query (selected from Querys.properties)
                2. Change Database
                3. Test Connection Pool
                4. Exit
                
                """;
    }

}


