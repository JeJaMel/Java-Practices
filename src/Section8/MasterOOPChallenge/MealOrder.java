package Section8.MasterOOPChallenge;

public class MealOrder {

    Burger burger;
    Item drink;
    Item sideItem;

    Burger basicBurger = new Burger("BURGER", 4.99, "Basic Burger");
    Item basicDrink = new Item("DRINK", 1.00, "Basic Drink");
    Item basicFries = new Item("FRIES", 2.00, "Basic Fries");

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
        drink.getAdjustedPrice();
    }

    public void printItemizedList() {
        System.out.println("-".repeat(50));
        System.out.println(burger.printItem());
        System.out.println(drink.printItem());
        System.out.println(sideItem.printItem());
        System.out.println("-".repeat(50));
    }

    public void getTotalPrice() {
        double totalPrice = burger.getTotalPrice() + drink.getAdjustedPrice() + sideItem.getAdjustedPrice();
        System.out.printf("Meal Order Total Price = %.2f\n", totalPrice);
    }
}
