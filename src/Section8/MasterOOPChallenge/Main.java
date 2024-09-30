package Section8.MasterOOPChallenge;

public class Main {

    public static void main(String[] args) {

        MealOrder mealOrder = new MealOrder();
        mealOrder.getTotalPrice();

        Burger basicBurger = new Burger("Burger", 4.99, "Basic Burger");
        Item basicDrink = new Item("Drink", 1.00, "Basic Drink");
        Item basicFries = new Item("Fries", 2.00, "Basic Fries");

        Item extraKetchup = new Item("Topping", 0.50, "Extra Ketchup");
        Item extraOnions = new Item("Topping", 0.50, "Extra Onions");
        Item extraLettuce = new Item("Topping", 0.50, "Extra Lettuce");
        Item cucumber = new Item("Topping", 0.50, "Cucumber");
        Item extraCheese = new Item("Topping", 0.50, "Extra Cheese");

        Item water = new Item("Drink", 1.00, "Water");
        Item fries = new Item("Fries", 1.50, "Fries");

        Burger burger = new Burger("Burger", 3.50, "Classic burger");

        MealOrder mealOrder2 = new MealOrder(burger, water, fries);
        mealOrder2.addToppings(extraKetchup, extraOnions, extraLettuce);
        mealOrder2.setDrinkSize("BIG");
        mealOrder2.printItemizedList();
        mealOrder2.getTotalPrice();

        MealOrder mealOrder3 = new MealOrder();
        mealOrder3.orderDeluxeBurger();
        mealOrder3.addToppings(extraKetchup, extraOnions, extraLettuce, cucumber, extraCheese);
        mealOrder3.printDeluxeItemizedList();
        mealOrder3.getDeluxeTotalPrice();
    }


}
