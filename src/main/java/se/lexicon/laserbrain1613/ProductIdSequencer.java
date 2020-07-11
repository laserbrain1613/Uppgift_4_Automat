package se.lexicon.laserbrain1613;

public class ProductIdSequencer {
    private static int productId = 1;

    public static int nextProductId() {
        return productId++;
    }
}
