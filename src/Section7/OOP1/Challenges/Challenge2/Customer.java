package Section7.OOP1.Challenges.Challenge2;

public class Customer {
    private String name;
    private double creditLimit;
    private String email;


    public Customer() {
        this("No username", 0000, "Default Email");

    }

    public Customer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;

    }

    public Customer(String name, String email) {
        this(name, 1000, email);

    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public void getCustomerData() {
        System.out.println("\nCustomer name: " + name);
        System.out.println("Customer email: " + email);
        System.out.println("Customer credit limit: " + creditLimit + "\n");
    }

}
