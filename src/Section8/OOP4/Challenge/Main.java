package Section8.OOP4.Challenge;

public class Main {

    public static void main(String[] args) {

        Printer duplexPrinter = new Printer(23, 5, true);
        duplexPrinter.addToner(50);
        duplexPrinter.printPages(24);
        System.out.println(duplexPrinter);

        Printer printer = new Printer(23, 5, false);
        printer.addToner(24);
        printer.printPages(24);
        System.out.println(printer);
    }
}