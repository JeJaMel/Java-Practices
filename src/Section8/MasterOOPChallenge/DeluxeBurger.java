package Section8.MasterOOPChallenge;

public class DeluxeBurger extends Burger {

    private Item extra1, extra2, extra3, extra4, extra5;
    private double totalPrice;


    public DeluxeBurger(String type, double price, String name) {
        super(type, price, name);
    }

    @Override
    public double addToppings(Item... extras) {
        if (extras.length > 0) {
            this.extra1 = extras[0];
        }
        if (extras.length > 1) {
            this.extra2 = extras[1];
        }
        if (extras.length > 2) {
            this.extra3 = extras[2];
        }
        if (extras.length > 3) {
            this.extra4 = extras[3];
        }
        if (extras.length > 4) {
            this.extra5 = extras[4];
        }
        return totalPrice;
    }

    @Override
    public String printBurger() {
        StringBuilder extrasString = new StringBuilder();
        if (extra1 != null) extrasString.append(extra1.printItem()).append("\n");
        if (extra2 != null) extrasString.append(extra2.printItem()).append("\n");
        if (extra3 != null) extrasString.append(extra3.printItem()).append("\n");
        if (extra4 != null) extrasString.append(extra4.printItem()).append("\n");
        if (extra5 != null) extrasString.append(extra5.printItem()).append("\n");
        return super.printItem() + "\nExtras: \n" + extrasString.toString();
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }
}
