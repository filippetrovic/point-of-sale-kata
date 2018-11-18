package software.craftsmanship.serbia.impl.domain.cart;

import software.craftsmanship.serbia.impl.catalog.*;

import java.util.*;

public class ShoppingCart {

    private List<ProductInfo> shoppingCart = new LinkedList<ProductInfo>();
    private double totalAmount = 0.0;

    public static ShoppingCart createEmptyShoppingCart() {
        return new ShoppingCart();
    }

    private ShoppingCart() {
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<ProductInfo> getShoppingCart() {
        return shoppingCart;
    }
}