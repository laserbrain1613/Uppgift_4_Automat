package se.lexicon.laserbrain1613.models;

public abstract class Product {

    private static int counter = 0;

    private String itemName;
    private int quantityInStock;
    private int itemPrice;
    private final int productId;

    public Product(String itemName, int quantityInStock, int itemPrice) {
        this.productId = ++counter;
        this.itemName = itemName;
        this.quantityInStock = quantityInStock;
        this.itemPrice = itemPrice;
    }

    public int getProductId() { return productId; }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public int getQuantityInStock() { return quantityInStock; }
    public void setQuantityInStock(int quantityInStock) { this.quantityInStock = quantityInStock; }
    public int getItemPrice() { return itemPrice; }
    public void setItemPrice(int itemPrice) { this.itemPrice = itemPrice; }

    // Assignment: Show product info. For example, price, name, calories, allergens, etc. (Return String)
    public String examine() {
        String summary = "";
        summary += ("--- Product details ---\n");
        summary += ("Product Id: " + getProductId()+"\n");
        summary += ("Item name: " + getItemName()+"\n");
        summary += ("Quantity in stock: " + getQuantityInStock()+"\n");
        summary += ("Item price " + getItemPrice()+"\n");
        return summary;
    }

    // Assignment: Use / consume the product. (Return String)
    public String use() { //
        this.quantityInStock--;
        return ("You have received '" + this.itemName + "' from the machine.");
        }

}