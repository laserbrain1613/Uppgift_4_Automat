package se.lexicon.laserbrain1613;

import se.lexicon.laserbrain1613.Product;
import se.lexicon.laserbrain1613.Beer;

public class Machine {
    //Fields
    private int moneyPool;
    private final Product[] soldProducts = new Product[10]; // Assuming this machine has 10 sell slots, but I won't fill all of them
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
                System.out.println("Machine did not recognize your currency"); // Placeholder for returning the item to the user
            }
        }
    }

    public int endSession() { //Returns change and resets the deposit pool
        int changeMoney = moneyPool;
        setMoneyPool(0);
        return changeMoney; // Kind of lazy approach. Might consider counting returned money and return appropriate denominators
    }

    public String getDescription(int productNumber) { //View a product description
        return soldProducts[productNumber-1].examine();
    }

    public int getBalance() { //Returns the deposit pool amount
        return moneyPool;
    } // Note to self: Duplicate of getMoneyPool()?



//    @Override
//    public String[] getProducts() { //Returns all Products' names and product numbers
//        return new String[0];
//    }
//
//    @Override
//    public Product request(int productNumber) {
//        return null;
//    }



}


// Don't know how to compare enum to String, using array for now
// public enum acceptedDenominations { ONE, TWO, FIVE, TEN, TWENTY, FIFTY, ONEHUNDRED, TWOHUNDRED, FIVEHUNDRED, ONETHOUSAND;}

// Another solution, but doesn't account for a failed attempt
//        for (int compare : acceptedDenominators) {
//                if (compare == insertMoney) {
//                setMoneyPool(moneyPool + insertMoney);
//                break;
//                }
