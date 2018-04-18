package software.craftsmanship.serbia.impl;

import software.craftsmanship.serbia.PointOfSale;
import software.craftsmanship.serbia.impl.catalog.Catalog;
import software.craftsmanship.serbia.impl.catalog.ProductInfo;
import software.craftsmanship.serbia.impl.display.SaleDisplay;
import software.craftsmanship.serbia.impl.display.message.MessageFactory;
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
            saleDisplay.display(MessageFactory.productInfo(productInfo.get()));
        } else {
            saleDisplay.display(MessageFactory.productNotFound());
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
