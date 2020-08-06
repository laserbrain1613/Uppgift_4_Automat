package se.lexicon.laserbrain1613;
import se.lexicon.laserbrain1613.models.*;

import java.util.Arrays;

public class Machine implements IVendingMachine {

    private int moneyPool = 0;
    private Product[] inventoryArray = new Product[0]; // Reflection: In real life, this array would have to be two-dimensional (amount of slots * capacity)
    private final int[] acceptedDenominators = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};

    public void stockMachine(Product product) {
        this.inventoryArray = Arrays.copyOf(this.inventoryArray, this.inventoryArray.length+1);
        this.inventoryArray[inventoryArray.length-1] = product;
    }

    public int[] getAcceptedDenominators() { return acceptedDenominators; }
    public int getBalance() {
        return this.moneyPool;
    }
    public void setBalance(int moneyPool) {
        this.moneyPool = moneyPool;
    }
    public Product[] findAll() {
        return inventoryArray;
    }

    // Assignment: View a product description
    public String getDescription(int productNumber) {
        if (productNumber > this.inventoryArray.length || this.inventoryArray[productNumber-1] == null) { // If product slot is either out of machine range or empty
            return "No product found on this index";
        }
        return this.inventoryArray[productNumber - 1].examine();
    }

    //Assignment: Add to the deposit pool (moneyPool)
    public void addCurrency(int insertMoney) {
        for (int i = 0; i < this.acceptedDenominators.length; i++) {
            if (this.acceptedDenominators[i] == insertMoney) {
                this.moneyPool += insertMoney;
                break;
            } else if (i == this.acceptedDenominators.length - 1) { // Did not find matching currency
                break; // Placeholder for returning the invalid item to the user
            }
        }
    }

    // Assignment: Returns change and resets the deposit pool
    public int endSession() {
        int changeMoney = this.moneyPool;
        this.moneyPool = 0;
        return changeMoney; // Reflection: Kind of a lazy approach. Machine should split up change money into proper denominators
    }

    // Assignment: Returns all Products' names and product numbers
    public String[] getProducts() {
        String[] temp = new String[0];
        for (Product product : this.inventoryArray) {
            if (product != null) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = (product.getProductId() + "\t" + product.getItemName());
            }
        }
        return temp;
    }

    //Assignment: Buy a Product. Note to self: Very very important that the array test goes first (or other checks might crash)
    public Product request(int productNumber) {
        if (productNumber > this.inventoryArray.length) { return null; } // Tried to buy product greater than machine slot size
        if (this.inventoryArray[productNumber-1] == null) { return null; } // Slot hasn't been stocked at all with a product
        if (this.inventoryArray[productNumber - 1].getQuantityInStock() == 0) { return null; } // Out of stock
        if (this.moneyPool < this.inventoryArray[productNumber - 1].getItemPrice()) { return null; } // Can't afford product

        this.moneyPool -= this.inventoryArray[productNumber - 1].getItemPrice(); // Deducts cost from balance
        String verification = this.inventoryArray[productNumber - 1].use(); //use / consume the product. (Return String)
        return this.inventoryArray[productNumber - 1];
    }

}