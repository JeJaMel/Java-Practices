package Section10.Challenges.GroceryList;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Grocery> groceryList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        System.out.println("Welcome to Grocery List");

        while (run) {

            System.out.println(optionsMenu());
            try {
                int option = sc.nextInt();

                switch (option) {

                    case 0:
                        run = false;
                        break;
                    case 1:
                        addToList(groceryList);
                        break;
                    case 2:
                        removeFromList(groceryList);
                        break;
                    case 3:
                        if (groceryList.isEmpty()) {
                            System.out.println("The grocery list is empty.");
                        } else {
                            for (Grocery item : groceryList) {
                                System.out.println(item);
                            }
                        }
                        break;

                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }

        }


    }

    public static String optionsMenu() {

        return """
                    \nPlease select and action
                0. Shutdown
                1. Add Item to list
                2. Remove Item from list
                3. Print list
                """;

    }

    public static void addToList(ArrayList<Grocery> grocery) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the grocery you wish to add: ");
        String name = sc.nextLine();

        if (grocery.contains(new Grocery(name))) {
            System.out.println("Grocery is already in the list");
            return;
        }
        System.out.println("Please enter the quantity of the grocery you wish to add: ");
        int quantity = sc.nextInt();

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0.");
            return;
        }

        grocery.add(new Grocery(name, quantity));
    }

    public static void removeFromList(ArrayList<Grocery> grocery) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the grocery you wish to remove: ");
        String name = sc.nextLine();

        Grocery itemToRemove = null;
        for (Grocery item : grocery) {
            if (item.name().equalsIgnoreCase(name)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            grocery.remove(itemToRemove);
            System.out.println("'" + name + "' has been removed from the list.");
        } else {
            System.out.println("'" + name + "' is not in the list.");
        }
    }


}