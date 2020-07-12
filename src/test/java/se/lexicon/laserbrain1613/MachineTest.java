package se.lexicon.laserbrain1613;

import org.junit.Before;
import org.junit.Test;
import sun.awt.SunHints;

import static org.junit.Assert.*;

public class MachineTest {
private Machine machine;

    @Before
    public void setUp()  {
        machine = new Machine();
        machine.replenishMachine(); // Fills array with 9 objects
    }

    @Test
    public void check_MoneyPool() {
        //Act
        int firstValue = machine.getBalance(); // Empty
        machine.setBalance(Integer.MAX_VALUE);
        int secondValue = machine.getBalance();

        //Assert
        assertEquals(0, firstValue);
        assertEquals(secondValue, Integer.MAX_VALUE);
    }

    @Test
    public void addCurrencyValidDenominators() {
        //Arrange
        int[] acceptedDenominators = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000}; // Adds up to 1888
        int result =0;

        //Act
        for (int sum : acceptedDenominators) {
            result += sum;
            machine.addCurrency(sum);
        }

        //Assert
        assertEquals(result, machine.getBalance());
    }

    @Test
    public void addCurrencyInvalidDenominators() {
        //Arrange
        int[] acceptedDenominators = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};

        //Act
        for (int sum : acceptedDenominators) {
            machine.addCurrency(sum + 2); // 3, 4, 7, 12 and so on
        }

        //Assert
        assertEquals(0, machine.getBalance());
    }


    @Test
    public void getDescription_FoundEntry() {
        //Arrange
        String str = machine.getDescription(9);

        //Assert
        assertTrue(str.contains("--- Item description ---"));
        assertTrue(str.contains("Flavor: Sweet"));
        assertTrue(str.contains("Color: Green"));
        assertTrue(str.contains("Weight: 5"));
        assertTrue(str.contains("Is a vegetable: No"));
    }

    @Test
    public void getDescription_EmptyIndex() {
        //Arrange
        String str = machine.getDescription(10);

        //Assert
        assertTrue(str.contains("No product found on this index"));
    }

    @Test
    public void getDescription_IndexOutOfBounds() {
        //Arrange
        String str = machine.getDescription(Integer.MAX_VALUE);

        //Assert
        assertTrue(str.contains("No product found on this index"));
    }

    @Test
    public void getProducts() {
        //Arrange
        String[] str;

        //Act
        str = machine.getProducts(); // Our test machine has 10 slots of which 9 are filled

        //Assert
        assertEquals(9, str.length);
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
    public void request() {

    }

    /*
    Scenarios:
    - Tries to buy a product that doesn't exist
    - Item is out of stock
    - Doesn't have enough money
    - Buys for exactly the pool amount
    - Wants to buy more items

    Check moneyPool in all scenarios
    Check return Product (actual Product or null)
     */

}