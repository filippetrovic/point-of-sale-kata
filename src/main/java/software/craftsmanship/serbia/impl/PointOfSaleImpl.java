package software.craftsmanship.serbia.impl;

import software.craftsmanship.serbia.*;
import software.craftsmanship.serbia.impl.catalog.*;
import software.craftsmanship.serbia.impl.display.*;
import software.craftsmanship.serbia.impl.display.message.*;
import software.craftsmanship.serbia.impl.domain.*;

import java.util.*;

public class PointOfSaleImpl implements PointOfSale {

    private SaleDisplay saleDisplay;
    private Catalog catalog;

    private double totalAmount = 0.0;

    public PointOfSaleImpl(SaleDisplay saleDisplay, Catalog catalog) {
        this.saleDisplay = saleDisplay;
        this.catalog = catalog;
    }

    @Override
    public void onBarcode(String barcode) {
        final Optional<ProductInfo> productInfo = catalog.getProductInfo(BarcodeFactory.from(barcode));

        if (productInfo.isPresent()) {

            totalAmount += productInfo.get().getPrice();

            saleDisplay.display(MessageFactory.productInfo(productInfo.get()));
        } else {
            saleDisplay.display(MessageFactory.productNotFound());
        }
    }

    @Override
    public void total() {
        saleDisplay.display(MessageFactory.total(totalAmount));
    }

    @Override
    public void onBarcodeRemove(String barcode) {
        final Optional<ProductInfo> productInfo = catalog.getProductInfo(BarcodeFactory.from(barcode));

        if (productInfo.isPresent()) {
            totalAmount -= productInfo.get().getPrice();
        } else {
            saleDisplay.display(MessageFactory.productNotFound());
        }

    }
}
