package Section8.MasterOOPChallenge;

public class Main {

    public static void main(String[] args) {

        MealOrder mealOrder = new MealOrder();
        mealOrder.getTotalPrice();

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

    }
}
