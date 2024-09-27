package Section8.OOP3.Challenges.Challenge1;

public class Main {

    public static void main(String[] args) {

        CoffeeMaker coffeeMaker = new CoffeeMaker();
        DishWater dishWater = new DishWater();
        Refrigerator refrigerator = new Refrigerator();

        SmartKitchen smartKitchen = new SmartKitchen(coffeeMaker, dishWater, refrigerator);

        smartKitchen.setKitchenStatus(true, false, true);
        smartKitchen.doKitchenWork();
    }
}