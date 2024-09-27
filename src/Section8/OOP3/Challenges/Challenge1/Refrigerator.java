package Section8.OOP3.Challenges.Challenge1;

public class Refrigerator {
    private boolean hasWorkToDO = false;

    public Refrigerator() {

    }

    public boolean setHasWorkToDO(boolean hasWorkToDO) {
        return this.hasWorkToDO = hasWorkToDO;
    }

    public void orderFood() {
        if (hasWorkToDO) {
            System.out.println("Ordering food...");
        }
    }

}

