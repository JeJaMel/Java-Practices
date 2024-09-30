package Section8.OOP5.Challenge.Challenge2;

public class Holden extends Car {

    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "The Holden " + this.getName() + " engine is starting";
    }

    @Override
    public String accelerate() {
        return "The Holden " + this.getName() + " accelerate";
    }

    @Override
    public String brake() {
        return "The Holden " + this.getName() + " is braking";
    }
}
