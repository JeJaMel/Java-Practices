package Section7.OOP2.Challenges.Challenge1;

public class SalariedEmployee extends Employee {

    private double annualSalary;
    private boolean isRetired = false;

    public SalariedEmployee(String name, String birthDate, String hireDate, double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }

    public boolean retire() {
        return isRetired = true;
    }

    @Override
    public double collectPay() {
        if (isRetired) {
            return ((annualSalary * 0.8) / 12) * 0.5;
        }
        return (annualSalary / 12) * 0.5;
    }
}
