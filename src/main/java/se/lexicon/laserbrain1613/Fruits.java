package se.lexicon.laserbrain1613;

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

    @Override
    public String examine() { //show product info. For example, price, name, calories, allergens, etc. (Return String)
        String summary = "";
        summary += ("--- Item description ---\n");
        summary += ("Flavor: " + getFlavor() + "\n");
        summary += ("Color: " + getColor() + "\n");
        summary += ("Weight: " + getWeight() + "\n");
        summary += ("Is a vegetable: " + (isAVegetable() ? "Yes" : "No") + "\n");
        return summary;
    }
}
