package Section8.OOP5.Challenge.Challenge1;

public class ElectricCar extends Car {

    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description) {
        super(description);
    }

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.printf("switch %d kWh battery on, Ready!%n", batterySize);
    }

    @Override
    protected void runEngine() {
        super.runEngine();
        System.out.printf("usage under the average: %.2f %n", avgKmPerCharge);

    }
}
