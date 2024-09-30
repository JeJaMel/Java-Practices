package Section8.OOP5.Challenge.Challenge2;

public class Ford extends Car {

    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "The Ford " + this.getName() + " engine is starting";
    }

    @Override
    public String accelerate() {
        return "The Ford " + this.getName() + " accelerate";
    }

    @Override
    public String brake() {
        return "The Ford " + this.getName() + " is braking";
    }
}
