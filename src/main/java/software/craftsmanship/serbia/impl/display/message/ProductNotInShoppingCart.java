package software.craftsmanship.serbia.impl.display.message;

class ProductNotInShoppingCart implements Message {

    public ProductNotInShoppingCart() {
    }

    @Override
    public String getFormattedMessage() {
        return "Product not found in shopping cart";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ProductNotInShoppingCart;
    }

    @Override
    public int hashCode() {
        return 2222;
    }

    @Override
    public String toString() {
        return "ProductNotInShoppingCart{}";
    }
}
