package se.lexicon.laserbrain1613;

public class Machine {
    //Fields
    private int moneyPool;
    private final Product[] inventoryArray = new Product[10]; // Assuming this machine has 10 sell slots, but I won't fill all of them
    private final int[] acceptedDenominators = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};

    //Getters and setters
    public int getMoneyPool() {
        return moneyPool;
    }

    public void setMoneyPool(int moneyPool) {
        this.moneyPool = moneyPool;
    }

    public void addCurrency(int insertMoney) { //Add to the deposit pool (moneyPool)
        for (int i = 0; i < acceptedDenominators.length; i++) {
            if (acceptedDenominators[i] == insertMoney) {
                setMoneyPool(moneyPool + insertMoney);
                break;
            } else if (i == acceptedDenominators.length - 1) { // Did not find matching currency at the end of the array
                break; // Placeholder for returning the item to the user (returning a boolean would've been more preferable)
            }
        }
    }

    public int endSession() { //Returns change and resets the deposit pool
        int changeMoney = moneyPool;
        setMoneyPool(0);
        return changeMoney; // Kind of a lazy approach. A vendor machine must count which and how many denominators to return
    }

    public String getDescription(int productNumber) { //View a product description
        return inventoryArray[productNumber - 1].examine();
    }

    public int getBalance() { //Returns the deposit pool amount
        return moneyPool;
    } // Note to self: Duplicate of getMoneyPool()?

    public String[] getProducts() { //Returns all Products' names and product numbers
        String[] temp = new String[inventoryArray.length];
        for (int i = 0; i < inventoryArray.length; i++) {
            String str = inventoryArray[i].getProductId() + inventoryArray[i].getItemName();
            temp[i] = str;
        }
        return temp;
    }

    public Product request(int productNumber) {
        if (inventoryArray[productNumber - 1].getQuantityInStock() > 0) { // Can't buy an item that isn't stocked
            if (moneyPool >= inventoryArray[productNumber - 1].getItemPrice()) {
                setMoneyPool(getBalance() - inventoryArray[productNumber - 1].getItemPrice()); // Deducts cost from balance
                String verification = inventoryArray[productNumber - 1].use(); //use / consume the product. (Return String)
                return inventoryArray[productNumber - 1];
            } else {
                return null; // Not enough money
            }
        }
        return null; // Out of stock
    }

}


// Don't know how to compare enum to String, using array for now
// public enum acceptedDenominations { ONE, TWO, FIVE, TEN, TWENTY, FIFTY, ONEHUNDRED, TWOHUNDRED, FIVEHUNDRED, ONETHOUSAND;}

// Another solution, but doesn't account for a failed attempt
//        for (int compare : acceptedDenominators) {
//                if (compare == insertMoney) {
//                setMoneyPool(moneyPool + insertMoney);
//                break;
//                }
