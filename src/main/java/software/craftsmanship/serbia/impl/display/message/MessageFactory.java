package software.craftsmanship.serbia.impl.display.message;

import software.craftsmanship.serbia.impl.catalog.*;

public class MessageFactory {

    public static Message productInfo(ProductInfo productInfo) {
        return new ProductInfoMessage(productInfo);
    }

    public static Message productNotFound() {
        return new ProductNotFoundMessage();
    }

    public static Message total(double totalAmount) {
        return new TotalMessage(totalAmount);
    }
}
