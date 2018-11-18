package software.craftsmanship.serbia.impl.catalog;

import software.craftsmanship.serbia.impl.domain.money.*;

import java.util.*;

public class ProductInfo {

    private MoneyAmount price;
    private String name;

    public ProductInfo(String name, MoneyAmount price) {
        this.price = price;
        this.name = name;
    }

    public MoneyAmount getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfo that = (ProductInfo) o;
        return Objects.equals(price, that.price) &&
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
