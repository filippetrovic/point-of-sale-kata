package software.craftsmanship.serbia.impl;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;
import software.craftsmanship.serbia.*;
import software.craftsmanship.serbia.impl.catalog.*;
import software.craftsmanship.serbia.impl.display.*;
import software.craftsmanship.serbia.impl.display.message.*;
import software.craftsmanship.serbia.impl.domain.barcode.*;
import software.craftsmanship.serbia.impl.domain.money.*;

import java.util.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PointOfSaleOnBarcodeTest {

    private static final String LAPTOP_BARCODE = "123456";

    @Mock
    private SaleDisplay saleDisplay;

    private PointOfSale pointOfSale;

    @Before
    public void setUp() {
        Catalog catalog = new InMemoryCatalog(new HashMap<Barcode, ProductInfo>() {{
            put(BarcodeFactory.from(LAPTOP_BARCODE), new ProductInfo("Laptop", MoneyAmount.serbianDinars(56.99)));
        }});

        pointOfSale = new PointOfSaleImpl(saleDisplay, catalog);
    }

    @Test
    public void shouldDisplayPriceOnDisplay() {

        // When
        pointOfSale.onBarcode(LAPTOP_BARCODE);

        // Then
        verify(saleDisplay)
                .display(MessageFactory.productInfo(new ProductInfo("Laptop", MoneyAmount.serbianDinars(56.99))));

    }

    @Test
    public void shouldDisplayProductNotFound() {

        // given
        String nonExistingProductBarcode = "1111111";

        // When
        pointOfSale.onBarcode(nonExistingProductBarcode);

        // Then
        verify(saleDisplay).display(MessageFactory.productNotFound());


    }
}
