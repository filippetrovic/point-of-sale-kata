package software.craftsmanship.serbia.impl.domain.cart;

import software.craftsmanship.serbia.impl.catalog.*;
import software.craftsmanship.serbia.impl.domain.money.*;

import java.util.*;

public class SimpleShoppingCart implements ShoppingCart {

    private List<ProductInfo> products = new LinkedList<>();
    private MoneyAmount total = MoneyAmount.serbianDinars(0.0);

    public static ShoppingCart createEmptyShoppingCart() {
        return new SimpleShoppingCart();
    }

    private SimpleShoppingCart() {
    }

    @Override
    public MoneyAmount getTotal() {
        return total;
    }

    @Override
    public void put(ProductInfo productInfo) {
        products.add(productInfo);
        total = total.plus(productInfo.getPrice());
    }

    @Override
    public void remove(ProductInfo productInfo) throws ProductNotFound {
        if (!products.contains(productInfo)) {
            throw new ProductNotFound(
                    String.format("%s is not found in shopping cart", productInfo));
        }

        products.remove(productInfo);
        total = total.minus(productInfo.getPrice());
    }

}