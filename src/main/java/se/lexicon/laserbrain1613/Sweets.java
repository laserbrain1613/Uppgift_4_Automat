package se.lexicon.laserbrain1613;

public class Sweets extends Product {
    private String category;
    private int weight;
    private boolean hasSugar;
    private boolean usesPlastic; // is either of plastic or carton

    public Sweets(String itemName, int quantityInStock, int itemPrice, String category, int weight, boolean hasSugar, boolean usesPlastic) {
        super(itemName, quantityInStock, itemPrice);
        this.category = category;
        this.weight = weight;
        this.hasSugar = hasSugar;
        this.usesPlastic = usesPlastic;
    }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    public boolean hasSugar() { return hasSugar; }
    public void setSugar(boolean hasSugar) { this.hasSugar = hasSugar; }
    public boolean isPlastic() { return usesPlastic; }
    public void setPlastic(boolean usesPlastic) { this.usesPlastic = usesPlastic; }

    //Assignment: Show product info. For example, price, name, calories, allergens, etc. (Return String)
    @Override
    public String examine() {
        String summary = "";
        summary += ("--- Item description ---\n");
        summary += ("Sweet Category: " + this.category + "\n");
        summary += ("Weight: " + this.weight + "\n");
        summary += ("Has sugar: " + (this.hasSugar ? "Yes" : "No") + "\n");
        summary += ("Container type: " + (this.usesPlastic ? "Plastic" : "Carton") + "\n");
        return summary;
    }


}
