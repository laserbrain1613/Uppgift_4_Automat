package se.lexicon.laserbrain1613;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SweetsTest {
    private final String name = "Test Sweets";
    private final int quantity = 10;
    private final int price = 20;
    private final String category = "Cake";
    private final int weight = 10;
    private final boolean hasSugar = true;
    private final boolean usesPlastic = true;
    private Sweets sweets;

    @Before
    public void setUp() {
        sweets = new Sweets(name, quantity, price, category, weight, hasSugar, usesPlastic);
    }

    @Test
    public void checkConstructor() {
        //Assert
        assertTrue(sweets.getProductId() > 0);
        assertEquals("Test Sweets", sweets.getItemName());
        assertEquals(10, sweets.getQuantityInStock());
        assertEquals(20, sweets.getItemPrice());
        assertEquals("Cake", sweets.getCategory());
        assertEquals(10, sweets.getWeight(), 0);
        assertTrue(sweets.isPlastic());
        assertTrue(sweets.hasSugar());
    }

    @Test
    public void checkSetters() {
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
        assertTrue(sweets.getProductId() > 0);
        assertEquals("New Name", sweets.getItemName());
        assertEquals(5, sweets.getQuantityInStock());
        assertEquals(10, sweets.getItemPrice());
        assertEquals("New Category", sweets.getCategory());
        assertEquals(20, sweets.getWeight(), 0);
        assertFalse(sweets.isPlastic());
        assertFalse(sweets.hasSugar());
    }

    @Test
    public void checkExamineString() {
        //Act
        String str = sweets.examine();

        //Assert
        assertTrue(sweets.getProductId() > 0);
        assertTrue(str.contains("--- Item description ---"));
        assertTrue(str.contains("Sweet Category: Cake"));
        assertTrue(str.contains("Weight: 10"));
        assertTrue(str.contains("Has sugar: Yes"));
        assertTrue(str.contains("Container type: Plastic"));
    }

    @Test
    public void checkExamineStringAfterChange() {
        //Arrange
        int productId = sweets.getProductId();
        sweets.setCategory("A New Category");

        //Act
        String str = sweets.examine();

        //Assert
        assertEquals(productId, sweets.getProductId());
        assertFalse(str.contains("Cake"));
        assertTrue(str.contains("A New Category"));
    }

}