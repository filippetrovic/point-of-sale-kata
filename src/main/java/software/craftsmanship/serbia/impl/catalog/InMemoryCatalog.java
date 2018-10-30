package software.craftsmanship.serbia.impl.catalog;

import software.craftsmanship.serbia.impl.domain.Barcode;

import java.util.Map;
import java.util.Optional;

public class InMemoryCatalog implements Catalog {

    private final Map<Barcode, ProductInfo> productCatalog;

    public InMemoryCatalog(Map<Barcode, ProductInfo> productCatalog) {
        this.productCatalog = productCatalog;
    }

    @Override
    public Optional<ProductInfo> getProductInfo(Barcode barcode) {
        return Optional.ofNullable(productCatalog.get(barcode));
    }

}
