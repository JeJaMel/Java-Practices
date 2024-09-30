package Section8.MasterOOPChallenge;

public class Burger extends Item {

    private Item extra1;
    private Item extra2;
    private Item extra3;
    private double totalPrice;

    public Burger(String type, double price, String name) {
        super(type, price, name);
    }

    public double addToppings(Item... extras) {
        totalPrice = this.getBasePrice();
        if (extras.length > 0) {
            this.extra1 = extras[0];
            totalPrice += extra1.getBasePrice();
        }
        if (extras.length > 1) {
            this.extra2 = extras[1];
            totalPrice += extra2.getBasePrice();
        }
        if (extras.length > 2) {
            this.extra3 = extras[2];
            totalPrice += extra3.getBasePrice();
        }
        return totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String printItem() {
        StringBuilder extrasString = new StringBuilder();
        if (extra1 != null) extrasString.append(extra1.printItem()).append("\n");
        if (extra2 != null) extrasString.append(extra2.printItem()).append("\n");
        if (extra3 != null) extrasString.append(extra3.printItem()).append("\n");
        return super.printItem() + "\nExtras: \n" + extrasString.toString();
    }
}
