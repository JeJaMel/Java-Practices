package Section7.OOP2.Inheritance;

public class Fish extends Animal {
    private int fins;
    private int gills;

    public Fish(String type, double weight, int fins, int gills) {
        super(type, "small", weight);
        this.fins = fins;
        this.gills = gills;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "fins=" + fins +
                ", gills=" + gills +
                "} " + super.toString();
    }

    private void moveMuscles() {
        System.out.println("muscles moving ");
    }

    private void moveBackFin() {
        System.out.println("backfin moving ");
    }

    @Override
    public void move(String speed) {
        super.move(speed);
        moveMuscles();
        if (speed == "fast") {
            moveBackFin();
        }
        System.out.println();
    }

    public void makeNoise() {
        System.out.println(type + " makes some kind of noise ");

    }
}
