package software.craftsmanship.serbia.impl.catalog;

import java.util.Objects;

public class ProductInfo {

    private double price;
    private String name;

    public ProductInfo(String name, double price) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductInfo that = (ProductInfo) o;
        return Double.compare(that.price, price) == 0 &&
             Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
             "price=" + price +
             ", name='" + name + '\'' +
             '}';
    }
}
