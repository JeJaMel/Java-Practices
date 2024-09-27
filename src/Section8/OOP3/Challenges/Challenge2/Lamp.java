package Section8.OOP3.Challenges.Challenge2;

public class Lamp {
    private String style;
    private boolean Battery;
    private int globRating;

    public Lamp(String style, boolean battery, int globRating) {
        this.style = style;
        Battery = battery;
        this.globRating = globRating;
    }

    public void turnOn() {
        System.out.println("Turning on the lamp");
    }

    public String getStyle() {
        return style;
    }

    public boolean isBattery() {
        return Battery;
    }

    public int getGlobRating() {
        return globRating;
    }
}
