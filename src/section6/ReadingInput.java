package section6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadingInput {

    public static void main(String[] args) {

        int currentYear = 2024;

        try {
            System.out.println(getInputFromConsole(currentYear));
        } catch (NullPointerException e) {
            System.out.println(getInputFromScanner(currentYear));
        }

    }

    public static String getInputFromConsole(int currentYear) {

        String name = System.console().readLine("Enter your name: ");
        int age = Integer.parseInt(System.console().readLine("Enter your age: "));
        int dateOfBirth = currentYear - age;

        return name + " is " + age + " years old and was born in " + dateOfBirth + ".";

    }

    public static String getInputFromScanner(int currentYear) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        boolean run = true;
        int age = 0;

        while (run) {
            try {
                System.out.println("Enter your age: ");
                age = sc.nextInt();
                if (checkdata(currentYear, age)) {
                    run = false;
                }
            }
            catch (InputMismatchException badUserData) {
                System.out.println("Characters not allowed! try again");
                sc.next();
            }
        }

        int dateOfBirth = currentYear - age;

        return name + " is " + age + " years old and was born in " + dateOfBirth + ".";
    }

    public static boolean checkdata(int currentYear, int age) {

        if (age > 125 || age < 0) {
            System.out.println("You entered an invalid date.");
            return false;
        }
        return true;
    }
}






