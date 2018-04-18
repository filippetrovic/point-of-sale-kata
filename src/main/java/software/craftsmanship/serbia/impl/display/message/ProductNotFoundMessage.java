package software.craftsmanship.serbia.impl.display.message;

class ProductNotFoundMessage implements Message {

    @Override
    public String getFormattedMessage() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ProductNotFoundMessage;
    }
}
