package software.craftsmanship.serbia.impl.catalog;

public class Price {

    private double price;

    public Price(double price) {
        this.price = price;
    }

    public double toDouble() {
        return price;
    }
}
