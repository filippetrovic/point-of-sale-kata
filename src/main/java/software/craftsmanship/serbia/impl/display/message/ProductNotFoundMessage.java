package software.craftsmanship.serbia.impl.display.message;

class ProductNotFoundMessage implements Message {

    @Override
    public String getFormattedMessage() {
        // This should probably come from i18n file
        return "Product not found";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ProductNotFoundMessage;
    }

    @Override
    public String toString() {
        return "ProductNotFoundMessage{}";
    }
}
