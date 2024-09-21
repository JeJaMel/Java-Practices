package Section7.OOP1Challenges.Challenge2;

public class Main {

    public static void main(String[] args) {

        System.out.println("Using 2 parameters constructor");
        Customer customer = new Customer("jejamel", "jejamel@gmail.com");
        customer.getCustomerData();

        System.out.println("Using 3 parameters constructor");
        Customer customer1 = new Customer("jejamel", 1250, "jejamel@gmail.com");
        customer1.getCustomerData();

        System.out.println("Using default parameters constructor");
        Customer customer2 = new Customer();
        customer2.getCustomerData();
    }

}
