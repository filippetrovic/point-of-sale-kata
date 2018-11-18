package software.craftsmanship.serbia.impl.display.message;

import software.craftsmanship.serbia.impl.catalog.*;

import java.util.*;

class ProductInfoMessage implements Message {

    private final ProductInfo productInfo;

    public ProductInfoMessage(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductInfoMessage productInfoMessage = (ProductInfoMessage) o;
        return Objects.equals(productInfo, productInfoMessage.productInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productInfo);
    }

    @Override
    public String toString() {
        return "ProductInfoMessage{" +
             "productInfo=" + productInfo +
             '}';
    }

    @Override
    public String getFormattedMessage() {
        // This should probably come from i18n file
        return String.format("%s: %.2f", productInfo.getName(), productInfo.getPrice().getAmount());
    }
}
