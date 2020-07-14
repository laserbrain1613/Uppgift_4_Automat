package se.lexicon.laserbrain1613.models;

public class Fruits extends Product {
    private String flavor;
    private String color;
    private int weight;
    private boolean isAVegetable; // Some vegetables are technically fruits

    public Fruits(String itemName, int quantityInStock, int itemPrice, String flavor, String color, int weight, boolean isAVegetable) {
        super(itemName, quantityInStock, itemPrice);
        this.flavor = flavor;
        this.color = color;
        this.weight = weight;
        this.isAVegetable = isAVegetable;
    }

    public String getFlavor() { return flavor; }
    public void setFlavor(String flavor) { this.flavor = flavor; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    public boolean isAVegetable() { return isAVegetable; }
    public void setAVegetable(boolean AVegetable) { isAVegetable = AVegetable; }

    // Assignment: Show product info. For example, price, name, calories, allergens, etc. (Return String)
    @Override
    public String examine() {
        String summary = "";
        summary += ("--- Item description ---\n");
        summary += ("Flavor: " + this.flavor + "\n");
        summary += ("Color: " + this.color + "\n");
        summary += ("Weight: " + this.weight + "\n");
        summary += ("Is a vegetable: " + (this.isAVegetable ? "Yes" : "No") + "\n");
        return summary;
    }

}