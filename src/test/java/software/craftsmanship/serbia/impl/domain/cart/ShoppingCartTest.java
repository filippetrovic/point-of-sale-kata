package software.craftsmanship.serbia.impl.domain.cart;

import org.junit.*;
import software.craftsmanship.serbia.impl.catalog.*;
import software.craftsmanship.serbia.impl.domain.money.*;

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
        MoneyAmount total = cart.getTotal();

        // then
        assertThat(total)
                .isEqualTo(MoneyAmount.serbianDinars(0.0));

    }

    @Test
    public void getTotalShouldReturnSumOfProductPrices() {

        // Given
        cart.put(new ProductInfo("dummy 1", MoneyAmount.serbianDinars(120.5)));
        cart.put(new ProductInfo("dummy 2", MoneyAmount.serbianDinars(0.5)));

        // When
        MoneyAmount total = cart.getTotal();

        // Then
        assertThat(total)
                .isEqualTo(MoneyAmount.serbianDinars(121.0));

    }

    @Test(expected = ProductNotFound.class)
    public void removeShouldThrowExceptionIfProductIsNotInCart() throws ProductNotFound {
        // Given
        cart.put(new ProductInfo("dummy", MoneyAmount.serbianDinars(222)));

        // When
        cart.remove(new ProductInfo("some other product", MoneyAmount.serbianDinars(333)));

        // Then
        // exception is thrown

    }

    @Test
    public void totalShouldNotCountRemovedProducts() throws ProductNotFound {
        // Given
        cart.put(new ProductInfo("product 1", MoneyAmount.serbianDinars(100)));
        cart.put(new ProductInfo("product 2", MoneyAmount.serbianDinars(100)));
        cart.put(new ProductInfo("product 1", MoneyAmount.serbianDinars(100)));
        cart.put(new ProductInfo("product 3", MoneyAmount.serbianDinars(200)));

        cart.remove(new ProductInfo("product 1", MoneyAmount.serbianDinars(100)));
        cart.remove(new ProductInfo("product 3", MoneyAmount.serbianDinars(200)));

        // When
        MoneyAmount total = cart.getTotal();

        // Then
        assertThat(total)
                .isEqualTo(MoneyAmount.serbianDinars(200.0));

    }
}
