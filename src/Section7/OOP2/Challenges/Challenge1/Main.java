package Section7.OOP2.Challenges.Challenge1;

public class Main {

    public static void main(String[] args) {

        Worker worker = new Worker("Jejamel", "12-04-2002");
        System.out.println(worker);

        Employee FirstEmployee = new Employee("Paco", "16-01-1989", "10-05-2015");
        System.out.println(FirstEmployee);

        SalariedEmployee SecondEmployee = new SalariedEmployee("Auron", "04-01-2000", "15-06-2024", 34000);
        System.out.println(SecondEmployee);

        System.out.println("Auron paycheck = " + SecondEmployee.collectPay());
        SecondEmployee.retire();
        System.out.println("Auron retirement paycheck = " + SecondEmployee.collectPay());

        HourlyEmployee ThirdEmployee = new HourlyEmployee("Ibai", "04-01-1992", "15-06-2016", 34);
        System.out.println(ThirdEmployee);

        System.out.println("Ibai weekly pay = " + ThirdEmployee.collectPay());
        ThirdEmployee.getDoublePay();
        System.out.println("Ibai holidays weekly pay = " + ThirdEmployee.getDoublePay());


    }


}

