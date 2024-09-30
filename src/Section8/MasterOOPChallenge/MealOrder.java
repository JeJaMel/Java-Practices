package Section8.MasterOOPChallenge;

public class MealOrder {

    private Burger burger;
    private Item drink;
    private Item sideItem;

    private Burger basicBurger = new Burger("BURGER", 4.99, "Basic Burger");
    private Item basicDrink = new Item("DRINK", 1.00, "Basic Drink");
    private Item basicFries = new Item("FRIES", 2.00, "Basic Fries");
    private DeluxeBurger deluxeBurger = new DeluxeBurger("BURGER", 9.99, "Deluxe Burger");

    public MealOrder() {
        this.burger = basicBurger;
        this.drink = basicDrink;
        this.sideItem = basicFries;
    }

    public MealOrder(Burger burger, Item drink, Item sideItem) {
        this.burger = burger;
        this.drink = drink;
        this.sideItem = sideItem;
    }

    public void orderDeluxeBurger() {
        this.burger = deluxeBurger;
        this.drink = basicDrink;
        this.sideItem = basicFries;
    }

    public double addToppings(Item... extras) {
        return burger.addToppings(extras);
    }

    public void setDrinkSize(String drinkSize) {
        if (drink.getType().equalsIgnoreCase("DRINK") || drink.getType().equalsIgnoreCase("FRIES")) {
            if (drinkSize.equalsIgnoreCase("SMALL") || drinkSize.equalsIgnoreCase("MEDIUM") || drinkSize.equalsIgnoreCase("BIG")) {
                drink.setSize(drinkSize);
            } else {
                System.out.println("Invalid drink size");
            }
        }
    }

    private void printItemizedList(Burger burger) {
        System.out.println("-".repeat(60));
        System.out.println(burger.printBurger());
        System.out.println(drink.printItem());
        System.out.println(sideItem.printItem());
        System.out.println("-".repeat(60));
    }

    public void printItemizedList() {
        printItemizedList(burger);
    }

    public void printDeluxeItemizedList() {
        printItemizedList(deluxeBurger);
    }

    public void getTotalPrice() {
        double totalPrice = burger.getTotalPrice() + drink.getAdjustedPrice() + sideItem.getAdjustedPrice();
        System.out.printf("Meal Order Total Price = %.2f\n", totalPrice);
    }

    public void getDeluxeTotalPrice() {
        double totalPrice = deluxeBurger.getBasePrice() + drink.getAdjustedPrice() + sideItem.getAdjustedPrice();
        System.out.printf("Meal Order Total Price = %.2f\n", totalPrice);
    }
}
