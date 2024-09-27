package Section8.OOP3.Challenges.Challenge1;

public class SmartKitchen {
    private CoffeeMaker brewMaster;
    private DishWater dishWater;
    private Refrigerator iceBox;

    public SmartKitchen(CoffeeMaker brewMaster, DishWater dishWater, Refrigerator iceBox) {
        this.brewMaster = brewMaster;
        this.dishWater = dishWater;
        this.iceBox = iceBox;
    }

    public void addWater() {
        brewMaster.setHasWorkToDO(true);
    }

    public void pourMilk() {
        iceBox.setHasWorkToDO(true);
    }

    public void loadDishWater() {
        dishWater.setHasWorkToDO(true);
    }

    public void setKitchenStatus(boolean coffeeMakerStatus, boolean dishWaterStatus, boolean refrigeratorStatus) {
        brewMaster.setHasWorkToDO(coffeeMakerStatus);
        dishWater.setHasWorkToDO(dishWaterStatus);
        iceBox.setHasWorkToDO(refrigeratorStatus);
    }

    public void doKitchenWork(){
        brewMaster.brewCoffee();
        dishWater.doDishes();
        iceBox.orderFood();
    }

}
