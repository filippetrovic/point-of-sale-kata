package software.craftsmanship.serbia.impl.display.message;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import software.craftsmanship.serbia.impl.domain.money.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(Parameterized.class)
public class TotalMessageTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {MoneyAmount.serbianDinars(1.0), "Total: 1.00"},
                {MoneyAmount.serbianDinars(11.0), "Total: 11.00"},
                {MoneyAmount.serbianDinars(112.0), "Total: 112.00"},
                {MoneyAmount.serbianDinars(1.5), "Total: 1.50"},
                {MoneyAmount.serbianDinars(1.01), "Total: 1.01"},
                {MoneyAmount.serbianDinars(1.99), "Total: 1.99"},
                {MoneyAmount.serbianDinars(0.0), "Total: 0.00"},
                {MoneyAmount.serbianDinars(0.01), "Total: 0.01"},
                {MoneyAmount.serbianDinars(0.90), "Total: 0.90"}
        });
    }

    private MoneyAmount totalAmount;
    private String expected;

    public TotalMessageTest(MoneyAmount totalAmount, String expected) {
        this.totalAmount = totalAmount;
        this.expected = expected;
    }

    @Test
    public void test() {
        // then
        final Message totalMessage = MessageFactory.total(totalAmount);

        // when
        final String messageText = totalMessage.getFormattedMessage();

        // then
        assertThat(messageText)
                .isNotNull()
                .isEqualToIgnoringNewLines(expected);
    }

}
