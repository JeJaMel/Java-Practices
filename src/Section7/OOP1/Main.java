package Section7.OOP1;

public class Main {

    public static void main(String[] args) {

    Car car = new Car();
    car.setModel("Mercedes-Benz Clase C");
    car.setMake("Mercedes-Benz");
    car.setColor("Gray");
    car.setDoors(4);
    car.setConvertible(false);

    car.describeCar();

    Car car2 = new Car();
        car2.setModel("Runner");
        car2.setMake("Ford");
        car2.setColor("Blue");
        car2.setDoors(4);
        car2.setConvertible(false);

    car2.describeCar();

    }

}

//important getter and setter
