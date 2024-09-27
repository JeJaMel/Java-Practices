package Section8.OOP3.Challenges.Challenge1;

public class CoffeeMaker {
    private boolean hasWorkToDO = false;

    public CoffeeMaker() {
    }

    public boolean setHasWorkToDO(boolean hasWorkToDO) {
        return this.hasWorkToDO = hasWorkToDO;
    }

    public void brewCoffee() {
        if (hasWorkToDO) {
            System.out.println("Brewing coffee...");
        }
    }
}
