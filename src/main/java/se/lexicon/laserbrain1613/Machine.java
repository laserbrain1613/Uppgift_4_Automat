package se.lexicon.laserbrain1613;

import java.util.Arrays;

public class Machine implements IVendingMachine {
    private int moneyPool = 0;
    private final Product[] inventoryArray = new Product[10]; // Reflection: In real life, this array would have to be two-dimensional (amount of slots * stored products in each slot)
    private final int[] acceptedDenominators = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};

    public int getBalance() {
        return this.moneyPool;
    }
    public void setBalance(int moneyPool) {
        this.moneyPool = moneyPool;
    }

    // Assignment: View a product description
    public String getDescription(int productNumber) {
        if (productNumber > this.inventoryArray.length || this.inventoryArray[productNumber-1] == null) {
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
        return changeMoney; // Reflection: Kind of a lazy approach. Machine should split up change money in proper denominators
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

    //Assignment: Buy a Product. Note to self: Very very important that array test goes first
    public Product request(int productNumber) {
        if (productNumber > this.inventoryArray.length) { return null; } // Tried to buy product greater than machine slot size
        if (this.inventoryArray[productNumber-1] == null) { return null; } // Slot hasn't been stocked at all with a product
        if (this.inventoryArray[productNumber - 1].getQuantityInStock() == 0) { return null; } // Out of stock
        if (this.moneyPool < this.inventoryArray[productNumber - 1].getItemPrice()) { return null; } // Can't afford product

        this.moneyPool -= this.inventoryArray[productNumber - 1].getItemPrice(); // Deducts cost from balance
        String verification = this.inventoryArray[productNumber - 1].use(); //use / consume the product. (Return String)
        return this.inventoryArray[productNumber - 1];
    }

    public void replenishMachine() {
        this.inventoryArray[0] = new Beer("Test Beer", 10, 20, "IPA", 6.5, "TestBrew Corporation", "Tastes really good", true, 330);
        this.inventoryArray[1] = new Beer("Fine Beer", 12, 25, "DIPA", 7.2, "FineBrew Corporation", "Great Taste", false, 500);
        this.inventoryArray[2] = new Beer("Extends", 1, 79, "Imperial Oatmeal Stout", 11.5, "Nerdbrewing", "Try it to believe it", true, 330);
        this.inventoryArray[3] = new Sweets("Lollipop", 19, 15, "Candy", 5, true, true);
        this.inventoryArray[4] = new Sweets("Marabou Mjölkchoklad", 0, 18, "Chocolate", 9, true, false);
        this.inventoryArray[5] = new Sweets("Guylian Stevia Dark Chocolate", 11, 23, "Chocolate", 7, false, false);
        this.inventoryArray[6] = new Fruits("Banana", 8, 12, "Mildly sweet", "Yellow", 4, false);
        this.inventoryArray[7] = new Fruits("Tomato", 12, 18, "Semi-sweet", "Red", 5, true);
        this.inventoryArray[8] = new Fruits("Apple", 4, 9, "Sweet", "Green", 5, false);
        //Leaving array index 9 empty for testing purposes
    }

}
