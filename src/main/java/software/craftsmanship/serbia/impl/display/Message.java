package software.craftsmanship.serbia.impl.display;

import software.craftsmanship.serbia.impl.catalog.ProductInfo;

import java.util.Objects;

public class Message {

    private final ProductInfo productInfo;

    public Message(ProductInfo productInfo) {
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
        Message message = (Message) o;
        return Objects.equals(productInfo, message.productInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productInfo);
    }

    @Override
    public String toString() {
        return "Message{" +
             "productInfo=" + productInfo +
             '}';
    }
}
