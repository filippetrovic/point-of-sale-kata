package software.craftsmanship.serbia.impl.display;

import software.craftsmanship.serbia.impl.catalog.ProductInfo;

import java.util.Objects;

public class ProductInfoMessage implements Message {

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
        return null;
    }
}
