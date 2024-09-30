package Section8.MasterOOPChallenge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Item> menuItems = new ArrayList<>();


    public static void main(String[] args) {

        MealOrder mealOrder = new MealOrder();
        mealOrder.getTotalPrice();

        Burger basicBurger = new Burger("Burger", 4.99, "Basic Burger");
        Item basicDrink = new Item("Drink", 1.00, "Basic Drink");
        Item basicFries = new Item("Fries", 2.00, "Basic Fries");

        Item extraKetchup = new Item("Topping", 0.50, "Extra Ketchup");
        Item extraOnions = new Item("Topping", 0.50, "Extra Onions");
        Item extraLettuce = new Item("Topping", 0.50, "Extra Lettuce");

        Item water = new Item("Drink", 1.00, "Water");
        Item fries = new Item("Fries", 1.50, "Fries");

        Burger burger = new Burger("Burger", 3.50, "Classic burger");

        MealOrder mealOrder2 = new MealOrder(burger, water, fries);
        mealOrder2.addToppings(extraKetchup, extraOnions, extraLettuce);
        mealOrder2.setDrinkSize("BIG");
        mealOrder2.printItemizedList();
        mealOrder2.getTotalPrice();

        menuItems.add(extraKetchup);
        menuItems.add(extraOnions);
        menuItems.add(extraLettuce);
        menuItems.add(water);
        menuItems.add(basicDrink);
        menuItems.add(fries);
        menuItems.add(basicFries);
        menuItems.add(basicBurger);
        menuItems.add(burger);

        printMenu();

    }

    public static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("-".repeat(50));
        for (Item item : menuItems) {
            System.out.println(item.printItem());
        }
        System.out.println("-".repeat(50));
    }

}
