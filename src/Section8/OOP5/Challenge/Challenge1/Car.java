package Section8.OOP5.Challenge.Challenge1;

public class Car {

    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println("Starting engine");
    }

    protected void runEngine() {
        System.out.println("Running engine");
    }

    public void drive() {
        System.out.println("Driving type is " + getClass().getSimpleName());
        runEngine();
    }



}


