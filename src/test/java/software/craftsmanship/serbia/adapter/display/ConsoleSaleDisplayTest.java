package software.craftsmanship.serbia.adapter.display;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;
import software.craftsmanship.serbia.impl.display.*;
import software.craftsmanship.serbia.impl.display.message.*;

import java.io.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleSaleDisplayTest {

    @Mock
    private PrintStream fakeOut;
    private PrintStream realOut;

    private SaleDisplay saleDisplay = new ConsoleSaleDisplay();

    @Before
    public void setUp() {
        realOut = System.out;
        System.setOut(fakeOut);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(realOut);
    }

    @Test
    public void shouldPrintMessageToSystemOut() {

        // when
        saleDisplay.display(MessageFactory.productNotFound());

        // then
        Mockito.verify(fakeOut)
                .println(MessageFactory.productNotFound().getFormattedMessage());
    }
}
