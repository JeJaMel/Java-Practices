package Section7.OOP1Challenge.OOP1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(23412, 411, "Jesus", "JeJaMelDev@gmail.com", "0414-2435491"   );
        boolean action = true;
        int choice = 0;

        System.out.println(bankAccount.getAccount_number());

        System.out.println("\nHi, " + bankAccount.getCustomerName() + ", what do you want to do? ");

        while (action) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. See info");
            System.out.println("4. Exit");

            try {
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
            } catch (InputMismatchException _) {

            }

            switch (choice) {

                case 1:
                    bankAccount.deposit();
                    break;
                case 2:
                    bankAccount.withdraw();
                    break;
                case 3:
                    bankAccount.printClientInfo();
                    break;
                case 4:
                    action = false;
                    break;
                default:
                    System.out.println("Please enter a valid number.");

            }

        }

    }

}

