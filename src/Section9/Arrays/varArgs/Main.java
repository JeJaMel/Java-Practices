package Section9.Arrays.varArgs;

public class Main {

    public static void main(String[] args) {

        System.out.println("=".repeat(20));
        printStuff(3, 4, 12);
        System.out.println("=".repeat(20));
        printStuff(3.5, 4.2, 12.9);
        System.out.println("=".repeat(20));
        printStuff("Hola", "Buenas", "noches");
        System.out.println("=".repeat(20));
    }

    //example of overloaded varArgs
    //also can use .split("") so initialize an array

    private static void printStuff(int... val) {
        for (int j : val) {
            System.out.println(j);
        }
    }

    private static void printStuff(double... val) {
        for (double j : val) {
            System.out.println(j);
        }
    }

    private static void printStuff(String... val) {
        for (String j : val) {
            System.out.println(j);
        }
    }


}
