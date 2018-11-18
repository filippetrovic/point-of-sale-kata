package software.craftsmanship.serbia.impl.catalog;

import software.craftsmanship.serbia.impl.domain.barcode.*;

import java.util.*;

public interface Catalog {

    Optional<ProductInfo> getProductInfo(Barcode barcode);

}
