package se.lexicon.laserbrain1613;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.lexicon.laserbrain1613.Product;

public class ProductTest {
    private Product pro;
    private final String name = "Test Name";
    private final int quantity = 5;
    private final int price = 20;

    @Before
    public void setUp() {
        pro = new Product(name, quantity, price);
    }

//    @After
//    public void startOver() {
//        pro = null;
//    }

    @Test
    public void testConstructor() {
        //assertEquals(1, pro.getProductId());
        assertEquals("Test Name", pro.getItemName());
        assertEquals(5, pro.getQuantityInStock());
        assertEquals(20, pro.getItemPrice());
    }

    @Test
    public void productId_increase() {
        //Arrange
        int firstValue = pro.getProductId();
        pro = new Product("Test1", 10, 40); // Pretends that we create new objects for the Machine array
        int secondValue = pro.getProductId();
        pro = new Product("Test2", 20, 80); // Pretends that we create new objects for the Machine array

        //Assert
        assertTrue((firstValue != secondValue) && (firstValue != pro.getProductId()));
    }

    @Test
    public void examine_Contents() {
        //Arrange
        String str = pro.examine();

        //Assert
        assertTrue(str.contains("--- Product details ---"));
        assertTrue(str.contains("Product Id:"));
        assertTrue(str.contains("Item name: Test"));
        assertTrue(str.contains("Quantity in stock: 5"));
        assertTrue(str.contains("Item price 20"));
    }

    @Test
    public void examine_ContentsAfterChange() {
        //Arrange
        pro.setItemName("New Name");
        pro.setQuantityInStock(50);
        pro.setItemPrice(100);

        //Assert
        //assertEquals(1, pro.getProductId());
        assertEquals("New Name", pro.getItemName());
        assertEquals(50, pro.getQuantityInStock());
        assertEquals(100, pro.getItemPrice());
    }

    @Test
    public void checkUse() {
        //Arrange
        int oldQuantity = pro.getQuantityInStock();

        //Act
        String returnValue = pro.use();

        //Assert
        assertEquals(oldQuantity-1, pro.getQuantityInStock());
        assertEquals("You have received a Test Name from the machine.", returnValue);
    }


}


