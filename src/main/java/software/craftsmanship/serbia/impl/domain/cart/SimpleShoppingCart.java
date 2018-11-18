package software.craftsmanship.serbia.impl.domain.cart;

import software.craftsmanship.serbia.impl.catalog.*;

import java.util.*;

public class SimpleShoppingCart implements ShoppingCart {

    private List<ProductInfo> products = new LinkedList<>();
    private double totalAmount = 0.0;

    public static ShoppingCart createEmptyShoppingCart() {
        return new SimpleShoppingCart();
    }

    private SimpleShoppingCart() {
    }

    @Override
    public double getTotal() {
        return totalAmount;
    }

    @Override
    public void put(ProductInfo productInfo) {
        products.add(productInfo);
        totalAmount += productInfo.getPrice();
    }

    @Override
    public void remove(ProductInfo productInfo) throws ProductNotFound {
        if (!products.contains(productInfo)) {
            throw new ProductNotFound(
                    String.format("%s is not found in shopping cart", productInfo));
        }

        products.remove(productInfo);
        totalAmount -= productInfo.getPrice();
    }

}