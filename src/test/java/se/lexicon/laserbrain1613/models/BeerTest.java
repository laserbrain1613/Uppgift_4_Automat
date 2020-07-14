package se.lexicon.laserbrain1613.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BeerTest {

    private Beer beer;
    final String name = "Test Beer";
    final int quantity = 10;
    final int price = 20;
    final String type = "IPA";
    final double abv = 6.5;
    final String manufacturer = "TestBrew Corporation";
    final String description = "Tastes really good";
    final boolean isCan = true;
    final int volume = 330;

    @Before
    public void setUp() {
        beer = new Beer(name, quantity, price, type, abv, manufacturer, description, isCan, volume);
    }

    @Test
    public void checkConstructor() {
        //Assert
        assertTrue(beer.getProductId() > 0);
        assertEquals(name, beer.getItemName());
        assertEquals(quantity, beer.getQuantityInStock());
        assertEquals(price, beer.getItemPrice());
        assertEquals(type, beer.getBeerType());
        assertEquals(abv, beer.getAlcoholByVolume(), 0);
        assertEquals(manufacturer, beer.getManufacturer());
        assertEquals(description, beer.getDescription());
        assertSame(isCan, beer.isACan());
        assertEquals(volume, beer.getVolume(), 0);
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
        assertTrue(str.contains((beer.isACan()) ? "Can" : "Bottle"));
        assertTrue(str.contains(beer.getBeerType()));
        assertTrue(str.contains(Integer.toString( beer.getVolume() )));
        assertTrue(str.contains(Double.toString( beer.getAlcoholByVolume() )));
        assertTrue(str.contains(beer.getManufacturer()));
        assertTrue(str.contains(beer.getDescription()));
    }

}