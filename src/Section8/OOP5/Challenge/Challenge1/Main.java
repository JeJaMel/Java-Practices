package Section8.OOP5.Challenge.Challenge1;

public class Main {

    public static void main(String[] args) {

//        Car car = new Car("2022 Blue Ferrari 296 GTS");
//        runRace(car);

        Car ferrari = new GasPoweredCar("Ferrari la ferrari", 15.4, 6);
        runRace(ferrari);

    }

    public static void runRace(Car car) {
        car.startEngine();
        car.drive();
    }
}
