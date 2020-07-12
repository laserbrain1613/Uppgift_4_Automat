package se.lexicon.laserbrain1613;

public class Product { // Note to self, what do all products have in common?
    private static int productId = 0;

    private String itemName;
    private int quantityInStock;
    private int itemPrice;

    public Product(String itemName, int quantityInStock, int itemPrice) {
        productId = ++productId;
        this.itemName = itemName;
        this.quantityInStock = quantityInStock;
        this.itemPrice = itemPrice;
    }

    public int getProductId() {
        return productId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    public int getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String examine() {
        String summary = "";
        summary += ("--- Product details ---\n");
        summary += ("Product Id: " + getProductId()+"\n");
        summary += ("Item name: " + getItemName()+"\n");
        summary += ("Quantity in stock: " + getQuantityInStock()+"\n");
        summary += ("Item price " + getItemPrice()+"\n");
        return summary;
    }

    public String use() { // use / consume the product. (Return String)
        setQuantityInStock(getQuantityInStock() - 1); // One less item in the machine
        return ("You have received a " + itemName + " from the machine."); //It would make more sense to return this (Product)
        }

}