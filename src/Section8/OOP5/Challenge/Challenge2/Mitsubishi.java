package Section8.OOP5.Challenge.Challenge2;

public class Mitsubishi extends Car {

    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "The Mitsubishi " + this.getName() + " engine is starting";
    }

    @Override
    public String accelerate() {
        return "The mitsubishi " + this.getName() + " accelerate";
    }

    @Override
    public String brake() {
        return "The mitsubishi " + this.getName() + " is braking";
    }
}
