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
import software.craftsmanship.serbia.impl.display.message.MessageFactory;
import software.craftsmanship.serbia.impl.domain.BarcodeFactory;

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
        when(catalog.getProductInfo(BarcodeFactory.from("123456")))
             .thenReturn(Optional.of(new ProductInfo("Laptop", 56.99)));

        // When
        pointOfSale.onBarcode("123456");

        // Then
        verify(saleDisplay).display(MessageFactory.productInfo(new ProductInfo("Laptop", 56.99)));

    }

    @Test
    public void shouldDisplayProductNotFound() {

        // Given
        when(catalog.getProductInfo(BarcodeFactory.from("123456")))
             .thenReturn(Optional.empty());

        // When
        pointOfSale.onBarcode("123456");

        // Then
        verify(saleDisplay).display(MessageFactory.productNotFound());


    }
}
