package software.craftsmanship.serbia.impl.domain.cart;

import software.craftsmanship.serbia.impl.catalog.*;

import java.util.*;

public class ShoppingCart {

    private List<ProductInfo> products = new LinkedList<>();
    private double totalAmount = 0.0;

    public static ShoppingCart createEmptyShoppingCart() {
        return new ShoppingCart();
    }

    private ShoppingCart() {
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void put(ProductInfo productInfo) {
        products.add(productInfo);
        totalAmount += productInfo.getPrice();
    }

    public void remove(ProductInfo productInfo) {
        products.remove(productInfo);
        totalAmount -= productInfo.getPrice();
    }

    public boolean contains(ProductInfo productInfo) {
        return products.contains(productInfo);
    }
}