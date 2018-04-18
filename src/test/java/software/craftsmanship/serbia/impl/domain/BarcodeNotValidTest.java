package software.craftsmanship.serbia.impl.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BarcodeNotValidTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
             {"asngl"},
             {""},
             {"  "},
             {"\n"},
             {"124 12421"},
             {"12412j41241"}
        });
    }

    private String input;

    public BarcodeNotValidTest(String input) {
        this.input = input;
    }

    @Test(expected = IllegalArgumentException.class)
    public void createBarcode() {
        BarcodeFactory.from(input);
    }
}
