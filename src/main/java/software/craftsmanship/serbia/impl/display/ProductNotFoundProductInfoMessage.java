package software.craftsmanship.serbia.impl.display;

public class ProductNotFoundProductInfoMessage implements Message {

    @Override
    public String getFormattedMessage() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ProductNotFoundProductInfoMessage;
    }
}
