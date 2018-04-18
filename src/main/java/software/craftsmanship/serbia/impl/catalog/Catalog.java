package software.craftsmanship.serbia.impl.catalog;

import software.craftsmanship.serbia.impl.domain.Barcode;

import java.util.Optional;

public interface Catalog {

    Optional<ProductInfo> getProductInfo(Barcode barcode);

}
