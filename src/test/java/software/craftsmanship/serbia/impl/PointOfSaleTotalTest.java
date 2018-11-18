package software.craftsmanship.serbia.impl;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;
import software.craftsmanship.serbia.*;
import software.craftsmanship.serbia.impl.catalog.*;
import software.craftsmanship.serbia.impl.display.*;
import software.craftsmanship.serbia.impl.domain.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class PointOfSaleTotalTest {

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
    public void shouldReturnZeroForTotal() {

        // When
        final String total = pointOfSale.total();

        // Then
        assertThat(total)
                .isNotNull()
                .isEqualToIgnoringNewLines("Total: 0.00");

    }

    @Test
    public void shouldReturnPriceOfOneProduct() {

        // Given
        pointOfSale.onBarcode(LAPTOP_BARCODE);

        // When
        String total = pointOfSale.total();

        // Then
        assertThat(total)
                .isNotNull()
                .isEqualToIgnoringNewLines("Total: 569.99");
    }

    @Test
    public void shouldReturnTotalPriceOfScannedProducts() {

        // Given
        pointOfSale.onBarcode(LAPTOP_BARCODE);
        pointOfSale.onBarcode(MONITOR_BARCODE);

        // When
        String total = pointOfSale.total();

        // Then
        assertThat(total)
                .isNotNull()
                .isEqualToIgnoringNewLines("Total: 914.98");
    }
}
