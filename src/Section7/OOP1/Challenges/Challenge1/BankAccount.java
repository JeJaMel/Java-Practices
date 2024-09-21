package Section7.OOP1.Challenges.Challenge1;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class BankAccount {

    private int account_number;
    private double balance;
    private String customerName;
    private String email;
    private String phone_number;

    public BankAccount() {
        this(12345, 0, "Default name", "Default email", "Default phone number");
        System.out.println("Default values showing...");
    }

    public BankAccount(int account_number, double balance, String customerName, String email, String phone_number) {
        this.account_number = account_number;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phone_number = phone_number;
    }

    public BankAccount(int account_number, String customerName) {
        this(account_number, 123, customerName, "Default email", "Default phone number" );
    }

    public int getAccount_number() {
        return account_number;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void deposit() {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        double amount = 0;
        double accountBalance = getBalance();
        System.out.println("\nYour currently balance is: " + accountBalance);

        try {
            System.out.println("How much do you want to deposit?");
            amount = sc.nextDouble();
            balance += amount;
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
        }
        System.out.println("Now your current balance is: " + this.balance + "\n");
    }

    public void withdraw() {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        double accountBalance = getBalance();
        System.out.println("\nYour currently balance is: " + accountBalance);
        double amount = 0.0;


        try {
            System.out.println("How much do you want to withdraw? (Max = " + accountBalance + ")");
            amount = sc.nextDouble();
            if (amount > accountBalance) {
                System.out.println("Your current balance is: " + this.balance + " you can't withdraw.\n");
                return;
            }
            balance -= amount;

        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
        }

        System.out.println("Now your current balance is: " + this.balance + "\n");

    }

    public void printClientInfo() {
        System.out.println("\n===================================================");
        System.out.println("Account number: " + account_number);
        System.out.println("Customer name: " + customerName);
        System.out.println("Email: " + email);
        System.out.println("Phone number: " + phone_number);
        System.out.println("Balance: " + balance);
        System.out.println("===================================================\n");

    }
}
