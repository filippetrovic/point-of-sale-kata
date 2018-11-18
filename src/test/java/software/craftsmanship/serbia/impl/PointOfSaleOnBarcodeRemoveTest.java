package software.craftsmanship.serbia.impl;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;
import software.craftsmanship.serbia.*;
import software.craftsmanship.serbia.impl.catalog.*;
import software.craftsmanship.serbia.impl.display.*;
import software.craftsmanship.serbia.impl.display.message.*;
import software.craftsmanship.serbia.impl.domain.*;

import java.util.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PointOfSaleOnBarcodeRemoveTest {

    private static final String LAPTOP_BARCODE = "111111";
    private static final String MONITOR_BARCODE = "222222";

    @Mock
    private SaleDisplay saleDisplay;

    private PointOfSale pointOfSale;

    @Before
    public void setUp() {
        Catalog catalog = new InMemoryCatalog(new HashMap<Barcode, ProductInfo>() {{
            put(BarcodeFactory.from(LAPTOP_BARCODE), new ProductInfo("Laptop", 569.99));
            put(BarcodeFactory.from(MONITOR_BARCODE), new ProductInfo("Monitor", 344.99));
        }});

        pointOfSale = new PointOfSaleImpl(saleDisplay, catalog);
    }

    @Test
    public void shouldReturnZeroForTotalAfterRemovingOnlyProduct() {

        // Given
        pointOfSale.onBarcode(LAPTOP_BARCODE);

        // When
        pointOfSale.onBarcodeRemove(LAPTOP_BARCODE);

        // Then
        pointOfSale.total();
        verify(saleDisplay)
                .display(MessageFactory.total(0.0));
    }

    @Test
    public void shouldExcludeRemovedProductFromTotal() {

        // Given
        pointOfSale.onBarcode(LAPTOP_BARCODE);
        pointOfSale.onBarcode(MONITOR_BARCODE);

        // When
        pointOfSale.onBarcodeRemove(MONITOR_BARCODE);

        // Then
        pointOfSale.total();
        verify(saleDisplay)
                .display(MessageFactory.total(569.99));
    }

}