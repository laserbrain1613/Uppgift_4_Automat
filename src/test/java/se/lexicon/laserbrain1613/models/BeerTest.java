package se.lexicon.laserbrain1613.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BeerTest {

    private Beer beer;

    @Before
    public void setUp() {
        final String name = "Test Beer";
        final int quantity = 10;
        final int price = 20;
        final String type = "IPA";
        final double abv = 6.5;
        final String manufacturer = "TestBrew Corporation";
        final String description = "Tastes really good";
        final boolean isCan = true;
        final int volume = 330;
        beer = new Beer(name, quantity, price, type, abv, manufacturer, description, isCan, volume);
    }

    @Test
    public void checkConstructor() {
        //Assert
        assertTrue(beer.getProductId() > 0);
        assertEquals("Test Beer", beer.getItemName());
        assertEquals(10, beer.getQuantityInStock());
        assertEquals(20, beer.getItemPrice());
        assertEquals("IPA", beer.getBeerType());
        assertEquals(6.5, beer.getAlcoholByVolume(), 0);
        assertEquals("TestBrew Corporation", beer.getManufacturer());
        assertEquals("Tastes really good", beer.getDescription());
        assertTrue(beer.isACan());
        assertEquals(330, beer.getVolume(), 0);
    }

    @Test
    public void checkSetters() {
        //Arrange
        int productId = beer.getProductId();
        beer.setItemName("New Name");
        beer.setQuantityInStock(5);
        beer.setItemPrice(10);
        beer.setBeerType("Stout");
        beer.setAlcoholByVolume(5.5);
        beer.setManufacturer("CompeteBrew Corporation");
        beer.setDescription("Tastes fantastic");
        beer.setACan(false);
        beer.setVolume(500);

        //Assert
        assertEquals(productId, beer.getProductId());
        assertEquals("New Name", beer.getItemName());
        assertEquals(5, beer.getQuantityInStock());
        assertEquals(10, beer.getItemPrice());
        assertEquals("Stout", beer.getBeerType());
        assertEquals(5.5, beer.getAlcoholByVolume(), 0);
        assertEquals("CompeteBrew Corporation", beer.getManufacturer());
        assertEquals("Tastes fantastic", beer.getDescription());
        assertFalse(beer.isACan());
        assertEquals(500, beer.getVolume(), 0);
    }

    @Test
    public void checkExamineString() {
        //Act
        String str = beer.examine();

        //Assert
        assertTrue(str.contains("--- Item description ---"));
        assertTrue(str.contains("Container Type: Can"));
        assertTrue(str.contains("Beer Type: IPA"));
        assertTrue(str.contains("Volume in ml: 330"));
        assertTrue(str.contains("Alcohol by volume: 6.5"));
        assertTrue(str.contains("Manufacturer: TestBrew Corporation"));
        assertTrue(str.contains("Description: Tastes really good"));
    }

    @Test
    public void checkExamineStringAfterChange() {
        //Arrange
        beer.setDescription("Tastes mediocre");

        //Act
        String str = beer.examine();

        //Assert
        assertTrue(str.contains("Description: Tastes mediocre"));
    }

}