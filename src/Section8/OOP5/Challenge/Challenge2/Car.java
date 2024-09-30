package Section8.OOP5.Challenge.Challenge2;

public class Car {
    private boolean engine = true;
    private int cylinders;
    private String name;
    private static int wheels = 4;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine() {
       return "The car engine is starting";
    }

    public String accelerate() {
        return "The car accelerate";
    }

    public String brake() {
        return "The car is braking";
    }
}
