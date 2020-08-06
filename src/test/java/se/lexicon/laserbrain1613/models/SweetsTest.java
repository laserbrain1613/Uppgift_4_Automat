package se.lexicon.laserbrain1613.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SweetsTest {

    private Sweets sweets;
    final String name = "Test Sweets";
    final int quantity = 10;
    final int price = 20;
    final String category = "Cake";
    final int weight = 10;
    final boolean hasSugar = true;
    final boolean usesPlastic = true;

    @Before
    public void setUp() {
        sweets = new Sweets(name, quantity, price, category, weight, hasSugar, usesPlastic);
    }

    @Test
    public void constructor() {
        //Assert
        assertTrue(sweets.getProductId() > 0);
        assertEquals(name, sweets.getItemName());
        assertEquals(quantity, sweets.getQuantityInStock());
        assertEquals(price, sweets.getItemPrice());
        assertEquals(category, sweets.getCategory());
        assertEquals(weight, sweets.getWeight(), 0);
        assertSame(hasSugar, sweets.isPlastic());
        assertEquals(usesPlastic, sweets.hasSugar());
    }

    @Test
    public void setters() {
        //Arrange
        int productId = sweets.getProductId();
        sweets.setItemName("New Name");
        sweets.setQuantityInStock(5);
        sweets.setItemPrice(10);
        sweets.setCategory("New Category");
        sweets.setWeight(20);
        sweets.setSugar(false);
        sweets.setPlastic(false);

        //Assert
        assertEquals(productId, sweets.getProductId());
        assertEquals("New Name", sweets.getItemName());
        assertEquals(5, sweets.getQuantityInStock());
        assertEquals(10, sweets.getItemPrice());
        assertEquals("New Category", sweets.getCategory());
        assertEquals(20, sweets.getWeight(), 0);
        assertFalse(sweets.isPlastic());
        assertFalse(sweets.hasSugar());
    }

    @Test
    public void examine() {
        //Act
        String str = sweets.examine();

        //Assert
        assertTrue(str.contains(sweets.getCategory()));
        assertTrue(str.contains(Integer.toString(sweets.getWeight())));
        assertTrue(str.contains(sweets.hasSugar() ? "Yes" : "No"));
        assertTrue(str.contains(sweets.isPlastic() ? "Plastic" : "Carton"));
    }

}