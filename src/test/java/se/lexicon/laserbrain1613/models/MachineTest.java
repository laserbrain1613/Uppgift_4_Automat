package se.lexicon.laserbrain1613.models;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.laserbrain1613.Machine;
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
        int[] acceptedDenominators = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
        int result =0;

        //Act
        for (int sum : acceptedDenominators) {
            result += sum; // Adds up to 1888
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
        String str = machine.getDescription(10); // Index 9 in the array was left empty on purpose

        //Assert
        assertTrue(str.contains("No product found on this index"));
    }

    @Test
    public void getDescription_IndexOutOfBounds() {
        //Arrange
        String str = machine.getDescription(11); // Index 10 does not exist

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
        assertTrue(str[0].contains("Test Beer"));
        assertTrue(str[3].contains("Lollipop"));
        assertTrue(str[6].contains("Banana"));
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
        machine.setBalance(20);

        //Act
        Product pro = machine.request(1); // Item costs 20

        //Assert
        assertEquals(0, machine.getBalance());
        assertNotNull(pro);
    }

    @Test
    public void request_NotEnoughMoney() {
        //Arrange
        machine.setBalance(19);

        //Act
        Product pro = machine.request(1); // Item costs 20, can't afford it

        //Assert
        assertEquals(19, machine.getBalance());
        assertNull(pro);
    }

    @Test
    public void request_OutOfStock () {
        //Arrange
        machine.setBalance(Integer.MAX_VALUE);

        //Act
        Product pro = machine.request(5);

        //Assert
        assertEquals(Integer.MAX_VALUE, machine.getBalance());
        assertNull(pro);
    }

    @Test
    public void request_ProductDoesNotExist() {
        //Arrange
        machine.setBalance(Integer.MAX_VALUE);

        //Act
        Product pro = machine.request(10); // Index 9 is empty (no object within)

        //Assert
        assertEquals(Integer.MAX_VALUE, machine.getBalance());
        assertNull(pro);
    }

    @Test
    public void request_ArrayOutOfBounds() {
        //Arrange
        machine.setBalance(Integer.MAX_VALUE);

        //Act
        Product product = machine.request(Integer.MAX_VALUE); // Out of range, array index is between 0-9 (10 elements)

        //Assert
        assertEquals(Integer.MAX_VALUE, machine.getBalance());
        assertNull(product);
    }

    @Test
    public void request_BuyMoreItems() { // I admit this test is a bit unnecessary
        //Arrange
        machine.setBalance(Integer.MAX_VALUE);
        int counter = 0;

        //Act
        for (int i = 1; i < 11 ; i++) {
            Product product = machine.request(i);
            counter += (product != null ? 1 : 0); // Won't buy from index 4 (out of stock) and 9 (null)
        }

        //Assert
        assertEquals(8, counter);

    }

}