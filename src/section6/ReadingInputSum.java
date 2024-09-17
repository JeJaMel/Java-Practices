package section6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadingInputSum {



    public static void main(String[] args) {

    sumInt();

    }

    public static void sumInt(){

        Scanner sc = new Scanner(System.in);

        int loop = 0, num = 0, sum = 0, x = 1;

        do {
            try {
                System.out.println("Enter number #" + x);
                num = sc.nextInt();
                sum += num;
                x++;
                loop++;
            } catch (InputMismatchException e) {
                System.out.println("Invalid value, try again.");
                sc.next();
            }

        } while (loop < 5);

        System.out.println("The sum of the 5 digits is: " + sum);


    }

}

