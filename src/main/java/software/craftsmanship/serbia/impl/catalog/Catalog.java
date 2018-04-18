package software.craftsmanship.serbia.impl.catalog;

import software.craftsmanship.serbia.impl.domain.Barcode;

public interface Catalog {

    ProductInfo getPrice(Barcode barcode);

}
