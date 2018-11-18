package software.craftsmanship.serbia.impl.catalog;

import org.junit.*;
import software.craftsmanship.serbia.impl.domain.barcode.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class CatalogTest {

    @Test
    public void shouldReturnProductInfo() {

        // Given
        final Barcode barcode = BarcodeFactory.from("12399");

        Catalog catalog = new InMemoryCatalog(new HashMap<Barcode, ProductInfo>(){{
            put(barcode, new ProductInfo("name", 22.1));
        }});

        // When
        Optional<ProductInfo> productInfo = catalog.getProductInfo(barcode);

        // Then
        assertThat(productInfo).isNotEmpty();
        assertThat(productInfo.get())
            .isEqualTo(new ProductInfo("name", 22.1));

    }

    @Test
    public void shouldReturnEmptyOptionalWhenThereIsNoProductWithSpecifiedBarcode() {
        // Given
        Catalog catalog = new InMemoryCatalog(Collections.emptyMap());

        Barcode queryBarcode = BarcodeFactory.from("12345");

        // When
        Optional<ProductInfo> productInfo = catalog.getProductInfo(queryBarcode);

        // Then
        assertThat(productInfo).isEmpty();
    }
}
