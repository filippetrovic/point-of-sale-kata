package software.craftsmanship.serbia.impl.display.message;

import software.craftsmanship.serbia.impl.catalog.ProductInfo;

public class MessageFactory {

    public static Message productInfo(ProductInfo productInfo) {
        return new ProductInfoMessage(productInfo);
    }

    public static Message productNotFound() {
        return new ProductNotFoundMessage();
    }

}
