package se.lexicon.laserbrain1613;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    private Product pro;

    @Before
    public void setUp() {
        pro = new Product("Test", 5, 20);
    }

    @After
    public void reset() {
        pro.resetCounter();
    }

    @Test
    public void testConstructor() {
        assertEquals(1, pro.getProductId());
        assertEquals("Test", pro.getItemName());
        assertEquals(5, pro.getQuantityInStock());
        assertEquals(20, pro.getItemPrice());
    }

    @Test
    public void productId_increase() {
        //Arrange
        int firstValue = pro.getProductId();
        pro = new Product("Test1", 10, 40);
        int secondValue = pro.getProductId();
        pro = new Product("Test2", 20, 80);

        //Assert
        assertEquals(1, firstValue);
        assertEquals(2, secondValue);
        assertEquals(3, pro.getProductId());
    }

    @Test
    public void examine_Contents() {
        //Arrange
        String str = pro.examine();

        //Assert
        assertTrue(str.contains("--- Product details ---"));
        assertTrue(str.contains("Product Id: 1"));
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
        assertEquals(1, pro.getProductId());
        assertEquals("New Name", pro.getItemName());
        assertEquals(50, pro.getQuantityInStock());
        assertEquals(100, pro.getItemPrice());
    }


}


