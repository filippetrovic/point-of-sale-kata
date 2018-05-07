package software.craftsmanship.serbia.impl.catalog;

import software.craftsmanship.serbia.impl.domain.Barcode;

import java.util.HashMap;
import java.util.Optional;

public class InMemoryCatalog implements Catalog {

    public InMemoryCatalog(HashMap<Barcode, ProductInfo> productCatalog) {

    }

    @Override
    public Optional<ProductInfo> getProductInfo(Barcode barcode) {
        return Optional.empty();
    }

}
