package personal.UniversityProjects.DBComponent;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, InterruptedException {

        /*
        Here in the main, I will create a mini example app to try the DBComponent Class methods.
        -Option to change the db, from PSQL to MySQL, Different DB same main usage.
        -Option to test the Connection Pool
        */

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

                    String[] params = db.getParameters(schema, queryName);

                    for (int i = 0; i < numThreads; i++) {
                        MyThreads thread = new MyThreads(db, schema, queryName, params);
                        thread.start();
                    }
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

    public static String QueryMenu() {
        return """
                    Enter the Schema and the Query name you want to execute.
                    (in case your db has no schemas, use public)
                
                """;
    }

}


