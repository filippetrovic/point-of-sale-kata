package software.craftsmanship.serbia.impl;

import software.craftsmanship.serbia.PointOfSale;
import software.craftsmanship.serbia.impl.catalog.Catalog;
import software.craftsmanship.serbia.impl.catalog.Price;
import software.craftsmanship.serbia.impl.display.Message;
import software.craftsmanship.serbia.impl.display.SaleDisplay;

public class PointOfSaleImpl implements PointOfSale {

    private SaleDisplay saleDisplay;
    private Catalog catalog;

    public PointOfSaleImpl(SaleDisplay saleDisplay, Catalog catalog) {
        this.saleDisplay = saleDisplay;
        this.catalog = catalog;
    }

    @Override
    public void onBarcode(String barcode) {
        final Price price = catalog.getPrice(barcode);

        saleDisplay.display(new Message(String.valueOf(price.toDouble())));

    }

    @Override
    public String total() {
        return null;
    }

    @Override
    public void onBarcodeRemove(String barcode) {

    }
}
