package Section8.OOP3.Challenges.Challenge1;

public class DishWater {
    private boolean hasWorkToDO = false;

    public DishWater() {
    }

    public boolean setHasWorkToDO(boolean hasWorkToDO) {
        return this.hasWorkToDO = hasWorkToDO;
    }

    public void doDishes() {
        if (hasWorkToDO) {
            System.out.println("Doing dishes...");
        }
    }
}
