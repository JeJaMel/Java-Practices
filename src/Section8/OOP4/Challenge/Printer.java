package Section8.OOP4.Challenge;

public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, int pagesPrinted, boolean duplex) {
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.pagesPrinted = pagesPrinted;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {
        if ((tonerLevel + tonerAmount) > 100 || (tonerLevel + tonerAmount) < 0) {
            System.out.println("Toner level is out of range.");
            return -1;
        }
        tonerLevel += tonerAmount;
        return tonerLevel;
    }

    public void printPages(int pages) {
        if (duplex) {
            pagesPrinted += ((pages / 2) + (pages % 2));
            System.out.println("Using duplex printer");
            System.out.printf("%d sheets will be used", pagesPrinted);
        } else {
            pagesPrinted += pages;
            System.out.println("Using printer");
            System.out.printf("%d sheets will be used ", pagesPrinted);
        }
    }

    @Override
    public String toString() {
        return "\nPrinter{" +
                "tonerLevel=" + tonerLevel +
                ", pagesPrinted=" + pagesPrinted +
                ", duplex=" + duplex +
                '}';
    }
}
