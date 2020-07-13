package se.lexicon.laserbrain1613;

public class Beer extends Product {

    private String beerType;
    private double alcoholByVolume;
    private String manufacturer;
    private String description;
    private boolean isACan; // false makes it a bottle
    private int volume;

    public Beer(String itemName, int quantityInStock, int itemPrice, String beerType, double alcoholByVolume, String manufacturer, String description, boolean isACan, int volume) {
        super(itemName, quantityInStock, itemPrice);
        this.beerType = beerType;
        this.alcoholByVolume = alcoholByVolume;
        this.manufacturer = manufacturer;
        this.description = description;
        this.isACan = isACan;
        this.volume = volume;
    }

    public String getBeerType() { return beerType; }
    public void setBeerType(String beerType) { this.beerType = beerType; }
    public double getAlcoholByVolume() { return alcoholByVolume; }
    public void setAlcoholByVolume(double alcoholByVolume) { this.alcoholByVolume = alcoholByVolume; }
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isACan() { return isACan; }
    public void setACan(boolean ACan) { isACan = ACan; }
    public int getVolume() { return volume; }
    public void setVolume(int volume) { this.volume = volume; }

    // Assignment: Show product info. For example, price, name, calories, allergens, etc. (Return String)
    @Override
    public String examine() {
        String summary = ""; //
        summary += ("--- Item description ---\n");
        summary += ("Container Type: " + ( this.isACan ? "Can" : "Bottle" ) + "\n");
        summary += ("Beer Type: " + this.beerType + "\n");
        summary += ("Volume in ml: " + this.volume + "\n");
        summary += ("Alcohol by volume: " + this.alcoholByVolume + "\n");
        summary += ("Manufacturer: " + this.manufacturer + "\n");
        summary += ("Description: " + this.description + "\n");
        return summary;
    }


}