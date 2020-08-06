package se.lexicon.laserbrain1613.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FruitsTest {

    private Fruits fruits;
    final String name = "Banana";
    final int quantity = 8;
    final int price = 12;
    final String flavor = "Mildly sweet";
    final String color = "Yellow";
    final int weight = 4;
    final  boolean isAVegetable = false;

    @Before
    public void setUp() {
        fruits = new Fruits(name, quantity, price, flavor, color, weight, isAVegetable);
    }

    @Test
    public void constructor() {
        //Assert
        assertTrue(fruits.getProductId() > 0);
        assertEquals(name, fruits.getItemName());
        assertEquals(quantity, fruits.getQuantityInStock());
        assertEquals(price, fruits.getItemPrice());
        assertEquals(flavor, fruits.getFlavor());
        assertEquals(color, fruits.getColor());
        assertEquals(weight, fruits.getWeight());
        assertFalse(fruits.isAVegetable());
    }

    @Test
    public void setters() {
        //Arrange
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
    public void examine() {
        //Act
        String str = fruits.examine();

        //Assert
        assertTrue(fruits.getProductId() > 0);
        assertTrue(str.contains(fruits.getFlavor()));
        assertTrue(str.contains(fruits.getColor()));
        assertTrue(str.contains(Integer.toString(fruits.getWeight())));
        assertTrue(str.contains(fruits.isAVegetable() ? "Yes" : "No"));
    }

}