package software.craftsmanship.serbia.impl;

import software.craftsmanship.serbia.PointOfSale;
import software.craftsmanship.serbia.impl.catalog.Catalog;
import software.craftsmanship.serbia.impl.catalog.ProductInfo;
import software.craftsmanship.serbia.impl.display.ProductInfoMessage;
import software.craftsmanship.serbia.impl.display.ProductNotFoundProductInfoMessage;
import software.craftsmanship.serbia.impl.display.SaleDisplay;
import software.craftsmanship.serbia.impl.domain.Barcode;

import java.util.Optional;

public class PointOfSaleImpl implements PointOfSale {

    private SaleDisplay saleDisplay;
    private Catalog catalog;

    public PointOfSaleImpl(SaleDisplay saleDisplay, Catalog catalog) {
        this.saleDisplay = saleDisplay;
        this.catalog = catalog;
    }

    @Override
    public void onBarcode(String barcode) {
        final Optional<ProductInfo> productInfo = catalog.getProductInfo(Barcode.from(barcode));

        if (productInfo.isPresent()) {
            saleDisplay.display(new ProductInfoMessage(productInfo.get()));
        } else {
            saleDisplay.display(new ProductNotFoundProductInfoMessage());
        }
    }

    @Override
    public String total() {
        return null;
    }

    @Override
    public void onBarcodeRemove(String barcode) {

    }
}
