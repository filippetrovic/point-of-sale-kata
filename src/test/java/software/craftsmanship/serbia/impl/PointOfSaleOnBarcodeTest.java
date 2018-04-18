package software.craftsmanship.serbia.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import software.craftsmanship.serbia.PointOfSale;
import software.craftsmanship.serbia.impl.catalog.Catalog;
import software.craftsmanship.serbia.impl.catalog.ProductInfo;
import software.craftsmanship.serbia.impl.display.SaleDisplay;
import software.craftsmanship.serbia.impl.display.message.ProductInfoMessage;
import software.craftsmanship.serbia.impl.display.message.ProductNotFoundProductInfoMessage;
import software.craftsmanship.serbia.impl.domain.Barcode;

import java.util.Optional;

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
        when(catalog.getProductInfo(Barcode.from("barcode")))
             .thenReturn(Optional.of(new ProductInfo("Laptop", 56.99)));

        // When
        pointOfSale.onBarcode("barcode");

        // Then
        verify(saleDisplay).display(new ProductInfoMessage(new ProductInfo("Laptop", 56.99)));

    }

    @Test
    public void shouldDisplayProductNotFound() {

        // Given
        when(catalog.getProductInfo(Barcode.from("not_found_barcode")))
             .thenReturn(Optional.empty());

        // When
        pointOfSale.onBarcode("not_found_barcode");

        // Then
        verify(saleDisplay).display(new ProductNotFoundProductInfoMessage());


    }
}
