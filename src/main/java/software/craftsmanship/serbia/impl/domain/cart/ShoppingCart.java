package software.craftsmanship.serbia.impl.domain.cart;

import software.craftsmanship.serbia.impl.catalog.*;

public interface ShoppingCart {
    double getTotal();

    void put(ProductInfo productInfo);

    void remove(ProductInfo productInfo) throws ProductNotFound;
}
