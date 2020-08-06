package se.lexicon.laserbrain1613.models;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.laserbrain1613.Machine;

import static org.junit.Assert.*;

public class MachineTest {

    private Machine machine;

    public void replenishMachine() { // Default replenishment
        machine.stockMachine( new Beer("Test Beer", 10, 20, "IPA", 6.5, "TestBrew Corporation", "Tastes really good", true, 330) );
        machine.stockMachine( new Beer("Fine Beer", 12, 25, "DIPA", 7.2, "FineBrew Corporation", "Great Taste", false, 500) );
        machine.stockMachine( new Beer("Extends", 1, 79, "Imperial Oatmeal Stout", 11.5, "Nerdbrewing", "Try it to believe it", true, 330) );
        machine.stockMachine( new Sweets("Lollipop", 19, 15, "Candy", 5, true, true) );
        machine.stockMachine( new Sweets("Marabou Mjölkchoklad", 0, 18, "Chocolate", 9, true, false) );
        machine.stockMachine( new Sweets("Guylian Stevia Dark Chocolate", 11, 23, "Chocolate", 7, false, false) );
        machine.stockMachine( new Fruits("Banana", 8, 12, "Mildly sweet", "Yellow", 4, false) );
        machine.stockMachine( new Fruits("Tomato", 12, 18, "Semi-sweet", "Red", 5, true) );
        machine.stockMachine( new Fruits("Apple", 4, 9, "Sweet", "Green", 5, false) );
    }

    @Before
    public void setUp()  {
        machine = new Machine();
        replenishMachine();
    }

    @Test
    public void getBalance() {
        //Act
        machine.setBalance(500);

        //Assert
        assertEquals(500, machine.getBalance());
    }

    @Test
    public void addCurrency_ValidDenominators() {
        //Arrange
        int result =0;

        //Act
        for (int sum : machine.getAcceptedDenominators()) {
            result += sum; //Adds every denominator to result
            machine.addCurrency(sum); //Attempts to add current denominator to pool
        }

        //Assert
        assertEquals(result, machine.getBalance());
    }

    @Test
    public void addCurrency_InvalidDenominator() {
        //Arrange
        machine.setBalance(25);

        //Act
        machine.addCurrency(Integer.MIN_VALUE); // Negative value is always impossible

        //Assert
        assertEquals(25, machine.getBalance());
    }

    @Test
    public void getDescription_FoundEntry() {
        //Arrange
        machine.stockMachine( new Fruits("Kiwi", 80, 20, "Super sweet", "Brown", 15, false) );
        String str = machine.getDescription(machine.findAll().length); // Most recently added product

        //Assert
        assertTrue(str.contains("Super sweet"));
        assertTrue(str.contains("Brown"));
        assertTrue(str.contains("15"));
        assertTrue(str.contains("No"));
    }

    @Test
    public void getDescription_FoundNoEntry() {
        //Arrange
        String str = machine.getDescription(Integer.MAX_VALUE);

        //Assert
        assertTrue(str.contains("No product found on this index"));
    }

    @Test
    public void getProducts() {
        //Arrange

        //Act
        String[] str = machine.getProducts();

        //Assert
        assertEquals(str.length, machine.findAll().length);
        }

    @Test
    public void endSession() {
        //Arrange
        machine.setBalance(50);

        //Act
        int change = machine.endSession();

        //Assert
        assertEquals(change, 50);
        assertEquals(0, machine.getBalance());
    }

    @Test
    public void request_IsWorking() {
        //Arrange
        machine.setBalance(Integer.MAX_VALUE);
        int oldBalance = machine.getBalance();

        //Act
        Product pro = machine.request(1);

        //Assert
        assertEquals(oldBalance - pro.getItemPrice(), machine.getBalance());
        assertSame("Test Beer", pro.getItemName());
        assertNotNull(pro);
    }

    @Test
    public void request_IsWorkingExactPoolAmount() {
        //Arrange
        machine.setBalance(machine.findAll()[0].getItemPrice());

        //Act
        Product pro = machine.request(1);

        //Assert
        assertEquals(0, machine.getBalance());
        assertNotNull(pro);
    }

    @Test
    public void request_NotEnoughMoney() {
        //Arrange
        machine.setBalance(machine.findAll()[0].getItemPrice() -1) ;
        int balance = machine.getBalance( );

        //Act
        Product pro = machine.request(1);

        //Assert
        assertEquals(balance, machine.getBalance());
        assertNull(pro);
    }

    @Test
    public void request_OutOfStock () {
        //Arrange
        machine.stockMachine( new Fruits("Kiwi", 0, 20, "Super sweet", "Brown", 15, false) );
        machine.setBalance(Integer.MAX_VALUE);

        //Act
        Product pro = machine.request(machine.findAll().length);

        //Assert
        assertEquals(Integer.MAX_VALUE, machine.getBalance());
        assertNull(pro);
    }

    @Test
    public void request_ArrayOutOfBounds() {
        //Arrange
        machine.setBalance(Integer.MAX_VALUE);

        //Act
        Product product = machine.request(Integer.MAX_VALUE);

        //Assert
        assertEquals(Integer.MAX_VALUE, machine.getBalance());
        assertNull(product);
    }

}