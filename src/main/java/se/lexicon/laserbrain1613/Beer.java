package se.lexicon.laserbrain1613;

public class Beer extends Product { // Note to self: What unique traits does this product have?

    private String beerType; // Stout, IPA or whatever
    private double alcoholByVolume;
    private String manufacturer;
    private String description;
    //private boolean isACan; // false makes it a bottle
    int volume;

    public Beer(int productId, String itemName, int quantityInStock, int itemPrice, String beerType, double alcoholByVolume, String manufacturer, String description, boolean isACan, int volume) {
        super(productId, itemName, quantityInStock, itemPrice);
        this.beerType = beerType;
        this.alcoholByVolume = alcoholByVolume;
        this.manufacturer = manufacturer;
        this.description = description;
//        this.isACan = isACan;
        this.volume = volume;
    }

    //Try not to GET too upSET


    public String getBeerType() {
        return beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }

    public double getAlcoholByVolume() {
        return alcoholByVolume;
    }

    public void setAlcoholByVolume(double alcoholByVolume) {
        this.alcoholByVolume = alcoholByVolume;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String examine() { //show product info. For example, price, name, calories, allergens, etc. (Return String)
        String summary = "";
        summary += ("--- Item description ---");
        //summary += ("Container Type: " + ( isACan() ? "Can" : "Bottle" ) + "\n");
        summary += ("Beer Type: " + getBeerType() + "\n");
        summary += ("Volume in ml: " + getVolume() + "\n");
        summary += ("Alcohol by volume: " + getAlcoholByVolume() + "\n");
        summary += ("Manufacturer: " + getManufacturer() + "\n");
        summary += ("Description: " + getDescription() + "\n");
        return summary;
    }

}