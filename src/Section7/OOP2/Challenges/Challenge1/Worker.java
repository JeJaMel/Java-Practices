package Section7.OOP2.Challenges.Challenge1;

public class Worker {

    private String name;
    private String birthDate;
    protected String endDate;

    public Worker() {
        this(null, null);
    }

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getAge(String birthDate) {
        int year = 2024;
        int birthYear = Integer.parseInt(birthDate.substring(6, 10));

        return year - birthYear;
    }

    public double collectPay() {
        return 0.0;
    }

    public void terminate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", age=" + getAge(getBirthDate()) + '\'' +
                '}';
    }

}
