package software.craftsmanship.serbia.impl;

import software.craftsmanship.serbia.PointOfSale;
import software.craftsmanship.serbia.impl.catalog.Catalog;
import software.craftsmanship.serbia.impl.catalog.ProductInfo;
import software.craftsmanship.serbia.impl.display.Message;
import software.craftsmanship.serbia.impl.display.SaleDisplay;
import software.craftsmanship.serbia.impl.domain.Barcode;

public class PointOfSaleImpl implements PointOfSale {

    private SaleDisplay saleDisplay;
    private Catalog catalog;

    public PointOfSaleImpl(SaleDisplay saleDisplay, Catalog catalog) {
        this.saleDisplay = saleDisplay;
        this.catalog = catalog;
    }

    @Override
    public void onBarcode(String barcode) {
        final ProductInfo productInfo = catalog.getPrice(Barcode.from(barcode));

        saleDisplay.display(new Message(productInfo));
    }

    @Override
    public String total() {
        return null;
    }

    @Override
    public void onBarcodeRemove(String barcode) {

    }
}
