package Section7.OOP2.Challenges.Challenge1;

public class SalariedEmployee extends Employee {

    private double annualSalary;
    private boolean isRetired = false;

    public SalariedEmployee(String name, String birthDate, long employeeID, String hireDate, double annualSalary, boolean isRetired) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    public boolean retire() {
        return isRetired = true;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "annualSalary=" + annualSalary +
                ", isRetired=" + isRetired +
                "} " + super.toString();
    }
}
