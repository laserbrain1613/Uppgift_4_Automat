package se.lexicon.laserbrain1613.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FruitsTest {

    private Fruits fruits;

    @Before
    public void setUp() {
        final String name = "Banana";
        final int quantity = 8;
        final int price = 12;
        final String flavor = "Mildly sweet";
        final String color = "Yellow";
        final int weight = 4;
        final  boolean isAVegetable = false;
        fruits = new Fruits(name, quantity, price, flavor, color, weight, isAVegetable);
    }

    @Test
    public void checkConstructor() {
        //Assert
        assertTrue(fruits.getProductId() > 0);
        assertEquals("Banana", fruits.getItemName());
        assertEquals(8, fruits.getQuantityInStock());
        assertEquals(12, fruits.getItemPrice());
        assertEquals("Mildly sweet", fruits.getFlavor());
        assertEquals("Yellow", fruits.getColor());
        assertEquals(4, fruits.getWeight());
        assertFalse(fruits.isAVegetable());
    }

    @Test
    public void checkSetters() {
        //Arrange
        int productId = fruits.getProductId();
        fruits.setItemName("Tomato");
        fruits.setQuantityInStock(5);
        fruits.setItemPrice(14);
        fruits.setFlavor("Sweet");
        fruits.setColor("Red");
        fruits.setWeight(6);
        fruits.setAVegetable(true);

        //Assert
        assertTrue(fruits.getProductId() > 0);
        assertEquals("Tomato", fruits.getItemName());
        assertEquals(5, fruits.getQuantityInStock());
        assertEquals(14, fruits.getItemPrice());
        assertEquals("Sweet", fruits.getFlavor());
        assertEquals("Red", fruits.getColor());
        assertEquals(6, fruits.getWeight());
        assertTrue(fruits.isAVegetable());
    }

    @Test
    public void checkExamineString() {
        //Act
        String str = fruits.examine();

        //Assert
        assertTrue(fruits.getProductId() > 0);
        assertTrue(str.contains("--- Item description ---"));
        assertTrue(str.contains("Flavor: Mildly sweet"));
        assertTrue(str.contains("Weight: 4"));
        assertTrue(str.contains("Is a vegetable: No"));
    }

    @Test
    public void checkExamineStringAfterChange() {
        //Arrange
        fruits.setAVegetable(true);

        //Act
        String str = fruits.examine();

        //Assert
        assertTrue(str.contains("Is a vegetable: Yes"));
    }

}