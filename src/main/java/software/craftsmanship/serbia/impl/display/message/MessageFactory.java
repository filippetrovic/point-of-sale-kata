package software.craftsmanship.serbia.impl.display.message;

import software.craftsmanship.serbia.impl.catalog.*;
import software.craftsmanship.serbia.impl.domain.money.*;

public class MessageFactory {

    public static Message productInfo(ProductInfo productInfo) {
        return new ProductInfoMessage(productInfo);
    }

    public static Message productNotFound() {
        return new ProductNotFoundMessage();
    }

    public static Message total(MoneyAmount totalAmount) {
        return new TotalMessage(totalAmount);
    }

    public static Message productNotInShoppingCart() {
        return new ProductNotInShoppingCart();
    }
}
