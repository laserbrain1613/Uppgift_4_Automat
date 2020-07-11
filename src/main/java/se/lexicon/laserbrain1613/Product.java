package se.lexicon.laserbrain1613;

public class Product { // Note to self, what do all products have in common?
    private int productId;
    private String itemName;
    private int quantityInStock;
    private int itemPrice;

    public Product(int productId, String itemName, int quantityInStock, int itemPrice) {
        this.productId = ProductIdSequencer.nextProductId();
        this.itemName = itemName;
        this.quantityInStock = quantityInStock;
        this.itemPrice = itemPrice;
    }
}