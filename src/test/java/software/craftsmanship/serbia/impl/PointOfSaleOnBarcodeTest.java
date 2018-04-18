package software.craftsmanship.serbia.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import software.craftsmanship.serbia.PointOfSale;
import software.craftsmanship.serbia.impl.catalog.Catalog;
import software.craftsmanship.serbia.impl.catalog.ProductInfo;
import software.craftsmanship.serbia.impl.display.Message;
import software.craftsmanship.serbia.impl.display.SaleDisplay;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PointOfSaleOnBarcodeTest {

    @Mock
    private Catalog catalog;

    @Mock
    private SaleDisplay saleDisplay;

    private PointOfSale pointOfSale;

    @Before
    public void setUp() {
        pointOfSale = new PointOfSaleImpl(saleDisplay, catalog);
    }

    @Test
    public void shouldDisplayPriceOnDisplay() {

        // Given
        when(catalog.getPrice("barcode")).thenReturn(new ProductInfo("Laptop", 56.99));

        // When
        pointOfSale.onBarcode("barcode");

        // Then
        verify(saleDisplay).display(new Message(new ProductInfo("Laptop", 56.99)));

    }

}
