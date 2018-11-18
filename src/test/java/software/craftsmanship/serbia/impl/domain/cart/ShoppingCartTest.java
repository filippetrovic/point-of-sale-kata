package software.craftsmanship.serbia.impl.domain.cart;

import org.junit.*;
import software.craftsmanship.serbia.impl.catalog.*;

import static org.assertj.core.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @Before
    public void setUp() {
        cart = SimpleShoppingCart.createEmptyShoppingCart();
    }

    @Test
    public void getTotalShouldReturnZeroWhenCartIsEmpty() {

        // given
        // carts is empty

        // when
        double total = cart.getTotal();

        // then
        assertThat(total)
                .isEqualTo(0.0);

    }

    @Test
    public void getTotalShouldReturnSumOfProductPrices() {

        // Given
        cart.put(new ProductInfo("dummy 1", 120.5));
        cart.put(new ProductInfo("dummy 2", 0.5));

        // When
        double total = cart.getTotal();

        // Then
        assertThat(total)
                .isEqualTo(121.0);

    }

    @Test(expected = ProductNotFound.class)
    public void removeShouldThrowExceptionIfProductIsNotInCart() throws ProductNotFound {
        // Given
        cart.put(new ProductInfo("dummy", 222));

        // When
        cart.remove(new ProductInfo("some other product", 333));

        // Then
        // exception is thrown

    }

    @Test
    public void totalShouldNotCountRemovedProducts() throws ProductNotFound {
        // Given
        cart.put(new ProductInfo("product 1", 100));
        cart.put(new ProductInfo("product 2", 100));
        cart.put(new ProductInfo("product 1", 100));
        cart.put(new ProductInfo("product 3", 200));

        cart.remove(new ProductInfo("product 1", 100));
        cart.remove(new ProductInfo("product 3", 200));

        // When
        double total = cart.getTotal();

        // Then
        assertThat(total)
                .isEqualTo(200.0);

    }
}
