package Section8.MasterOOPChallenge;

public class MealOrder {

    private Burger burger;
    private Item drink;
    private Item sideItem;

    Burger basicBurger = new Burger("BURGER", 4.99, "Basic Burger");
    Item basicDrink = new Item("DRINK", 1.00, "Basic Drink");
    Item basicFries = new Item("FRIES", 2.00, "Basic Fries");
    DeluxeBurger deluxeBurger = new DeluxeBurger("BURGER", 9.99, "Deluxe Burger");

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
        if (drink.getType().toUpperCase().equals("DRINK") || drink.getType().toUpperCase().equals("FRIES")) {
            if (drinkSize.toUpperCase().equals("SMALL") || drinkSize.toUpperCase().equals("MEDIUM") || drinkSize.toUpperCase().equals("BIG")) {
                drink.setSize(drinkSize);
            } else {
                System.out.println("Invalid drink size");
            }
        }
    }

    public void printItemizedList() {
        System.out.println("-".repeat(60));
        System.out.println(burger.printBurger());
        System.out.println(drink.printItem());
        System.out.println(sideItem.printItem());
        System.out.println("-".repeat(60));
    }

    public void printDeluxeItemizedList() {
        System.out.println("-".repeat(60));
        System.out.println(deluxeBurger.printBurger());
        System.out.println(drink.printItem());
        System.out.println(sideItem.printItem());
        System.out.println("-".repeat(60));
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
