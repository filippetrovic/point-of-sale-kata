package software.craftsmanship.serbia.impl.catalog;

import org.junit.Test;
import software.craftsmanship.serbia.impl.domain.Barcode;
import software.craftsmanship.serbia.impl.domain.BarcodeFactory;

import java.util.HashMap;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTest {

    @Test
    public void shouldReturnProductInfo() {

        // Given
        Barcode barcode = BarcodeFactory.from("12399");

        Catalog catalog = new InMemoryCatalog(new HashMap<>());

        // When
        Optional<ProductInfo> productInfo = catalog.getProductInfo(barcode);

        // Then
        assertThat(productInfo).isNotEmpty();

    }
}
