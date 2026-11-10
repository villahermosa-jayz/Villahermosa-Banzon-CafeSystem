/**
 * Represents a general item sold at the campus cafe.
 * @author Nick Banzon
 * @version 1.0
 */
public abstract class MenuItem {

    protected String name;
    protected double basePrice;
    private String itemCode;

    public MenuItem() {
        this.name = "Unnamed Item";
        this.basePrice = 0.0;
        this.itemCode = "N/A";
    }

    public MenuItem(String name, double basePrice, String itemCode) {
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
    }

    public abstract double computePrice();

    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: item name cannot be blank.");
        }
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            System.out.println("Error: base price cannot be negative.");
        }
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode;
        } else {
            System.out.println("Error: item code cannot be blank.");
        }
    }
}