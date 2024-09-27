package Section8.OOP3.Composition;

public class PersonalComputer extends Product {

    private Monitor monitor;
    private Motherboard motherboard;
    private ComputerCase computerCase;

    public PersonalComputer(String model, String manufacturer, Monitor monitor, Motherboard motherboard, ComputerCase computerCase) {
        super(model, manufacturer);
        this.monitor = monitor;
        this.motherboard = motherboard;
        this.computerCase = computerCase;
    }

    private void drawLogo(){
        monitor.drawPixelAt(1200, 50, "Yellow");
    }

    public void powerUp(){
        computerCase.pressPowerButton();
        drawLogo();
    }

}
