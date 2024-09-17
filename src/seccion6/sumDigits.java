package seccion6;

public class sumDigits {

    public static void main(String[] args) {

        int number = 1234567;
        int sum = sumDigit(number);
        System.out.println("\n==========================================================");
        System.out.println("The sum of the digit " + number + " is: " + sum);
        System.out.println("==========================================================");
    }

    public static int sumDigit(int number) {
        if (number < 0) {
            return -1;
        }
        int sum = 0;

        while (number > 0) {
            System.out.println("\nGetting the last " + number + " digit");
            int digit = number % 10;
            System.out.println("Adding the last digit to the variable sum");
            sum += digit;
            System.out.println("Removing the last digit..." + number);
            number /= 10;
        }
        return sum;

    }


}






