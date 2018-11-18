package software.craftsmanship.serbia.impl.domain.cart;

import software.craftsmanship.serbia.impl.catalog.*;

import java.util.*;

public class ShoppingCart {
    private double totalAmount = 0.0;

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    private List<ProductInfo> shoppingCart = new LinkedList<ProductInfo>();

    public List<ProductInfo> getShoppingCart() {
        return shoppingCart;
    }

    public ShoppingCart() {
    }
}