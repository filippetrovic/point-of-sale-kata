package software.craftsmanship.serbia.impl.domain.cart;

import software.craftsmanship.serbia.impl.catalog.*;
import software.craftsmanship.serbia.impl.domain.money.*;

public interface ShoppingCart {
    MoneyAmount getTotal();

    void put(ProductInfo productInfo);

    void remove(ProductInfo productInfo) throws ProductNotFound;
}
