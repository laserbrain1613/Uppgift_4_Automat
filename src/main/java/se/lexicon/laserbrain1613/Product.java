package se.lexicon.laserbrain1613;

public abstract class Product { // Note to self, what do all products have in common?
    private static int productId = 1;

    private String itemName;
    private int quantityInStock;
    private int itemPrice;

    public Product(String itemName, int quantityInStock, int itemPrice) {
        productId = productId++;
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
        summary += ("--- Product details ---");
        summary += ("Product Id: " + getProductId());
        summary += ("Item name: " + getItemName());
        summary += ("Quantity in stock: " + getQuantityInStock());
        summary += ("Item price " + getItemPrice());
        return summary;
    }

}