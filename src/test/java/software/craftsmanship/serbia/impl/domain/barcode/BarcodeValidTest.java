package software.craftsmanship.serbia.impl.domain.barcode;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import java.util.*;

@RunWith(Parameterized.class)
public class BarcodeValidTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
             {"1"},
             {"12"},
             {"1234"},
             {"097"},
             {"91264812"},
             {"1241241241"}
        });
    }

    private String input;

    public BarcodeValidTest(String input) {
        this.input = input;
    }

    @Test
    public void createBarcode() {
        BarcodeFactory.from(input);
    }
}
