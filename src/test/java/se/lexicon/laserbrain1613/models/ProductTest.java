package se.lexicon.laserbrain1613.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductTest {

    private Product product;

    @Before
    public void setUp() {
        product = new Product("Test Beer",5, 50) {}; // Creates Product without a child
    }

    @Test
    public void use() {
        //Arrange
        int oldQuantity = product.getQuantityInStock();

        //Act
        String str = product.use();

        //Assert
        assertTrue(str.contains(product.getItemName()));
        assertEquals(oldQuantity-1, product.getQuantityInStock());
    }

    @Test
    public void setters() {
        //Arrange
        product.setItemName("New Name");
        product.setQuantityInStock(20);
        product.setItemPrice(40);

        //Assert
        assertEquals("New Name", product.getItemName());
        assertEquals(20, product.getQuantityInStock());
        assertEquals(40, product.getItemPrice());
    }

    @Test
    public void getProductId() {
        //Assert
        assertTrue(product.getProductId() > 0); // Can't predict order of tests
    }

    @Test
    public void examine() {
        //Act
        String str = product.examine();

        //Assert
        assertTrue(str.contains(Integer.toString(product.getProductId())));
        assertTrue(str.contains(product.getItemName()));
        assertTrue(str.contains(Integer.toString(product.getQuantityInStock())));
        assertTrue(str.contains(Integer.toString(product.getItemPrice())));
    }

}