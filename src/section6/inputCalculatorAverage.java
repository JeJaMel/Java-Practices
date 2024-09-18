package section6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class inputCalculatorAverage {

    public static void main(String[] args) {

        inputThenPrintSumAndAverage();

    }

    public static void inputThenPrintSumAndAverage() {

        Scanner sc = new Scanner(System.in);
        int count = 0, sum = 0, num = 0;
        double average = 0;
        System.out.println("Add numbers to the sum, press any letter to finish.");

        while (true) {
            try {
                System.out.print("Enter number: ");
                num = sc.nextInt();
                sum += num;
                count++;
            }catch (InputMismatchException e) {
                average = (double) sum / count;
                System.out.println("SUM = " + sum + " AVG = " + average);

                break;
            }

        }

    }

}




