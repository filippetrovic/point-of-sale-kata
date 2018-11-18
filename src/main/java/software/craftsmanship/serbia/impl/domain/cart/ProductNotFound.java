package software.craftsmanship.serbia.impl.domain.cart;

public class ProductNotFound extends Exception {
    public ProductNotFound(String message) {
        super(message);
    }
}
