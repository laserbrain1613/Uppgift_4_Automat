package se.lexicon.laserbrain1613;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductTest {

    private Product product;

    @Before
    public void setUp() {
        product = new Beer("Test Beer", 10, 20, "IPA", 6.5, "TestBrew Corporation", "Tastes really good", true, 330);
    }

    @Test
    public void use() {
        //Arrange
        int oldQuantity = product.getQuantityInStock();

        //Act
        String str = product.use();

        //Assert
        assertTrue(str.contains("You have received a Test Beer from the machine."));
        assertEquals(oldQuantity-1, product.getQuantityInStock());
    }

    @Test
    public void checkSetters() {
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



}



