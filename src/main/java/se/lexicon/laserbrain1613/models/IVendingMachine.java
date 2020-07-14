package se.lexicon.laserbrain1613.models;

public interface IVendingMachine {

    void addCurrency(int amount);              //Add to the deposit pool (moneyPool)
    Product request(int productNumber);        //Buy a Product
    int endSession();                          //Returns change and resets the deposit pool
    String getDescription(int productNumber);  //View a product description
    int getBalance();                          //Returns the deposit pool amount
    String [] getProducts();                   //Returns all Products' names and product numbers

}