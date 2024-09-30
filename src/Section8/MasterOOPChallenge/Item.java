package Section8.MasterOOPChallenge;

public class Item {
    private String name;
    private String type;
    private double price;
    private String size = "MEDIUM";

    public Item(String type, double price, String name) {
        this.type = type.toUpperCase();
        this.name = name.toUpperCase();
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getBasePrice() {
        return price;
    }

    public double getAdjustedPrice() {
        return switch (size.toUpperCase()) {
            case "SMALL" -> getBasePrice() - 0.5;
            case "BIG" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String printItem() {
        return "[Name: " + name + " Type: " + type + " Price: " + getAdjustedPrice() + " Size: " + size + "]";
    }
}
