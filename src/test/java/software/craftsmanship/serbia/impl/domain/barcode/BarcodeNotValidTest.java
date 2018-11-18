package software.craftsmanship.serbia.impl.domain.barcode;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import java.util.*;

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
