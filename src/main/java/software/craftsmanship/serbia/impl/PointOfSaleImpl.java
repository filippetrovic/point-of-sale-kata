package software.craftsmanship.serbia.impl;

import software.craftsmanship.serbia.*;
import software.craftsmanship.serbia.impl.catalog.*;
import software.craftsmanship.serbia.impl.display.*;
import software.craftsmanship.serbia.impl.display.message.*;
import software.craftsmanship.serbia.impl.domain.barcode.*;

import java.util.*;

public class PointOfSaleImpl implements PointOfSale {

    private SaleDisplay saleDisplay;
    private Catalog catalog;

    private double totalAmount = 0.0;
    private List<ProductInfo> shoppingCart = new LinkedList<>();

    public PointOfSaleImpl(SaleDisplay saleDisplay, Catalog catalog) {
        this.saleDisplay = saleDisplay;
        this.catalog = catalog;
    }

    @Override
    public void onBarcode(String barcode) {
        final Optional<ProductInfo> productInfo = catalog.getProductInfo(BarcodeFactory.from(barcode));

        if (productInfo.isPresent()) {

            final ProductInfo scannedProduct = productInfo.get();

            shoppingCart.add(scannedProduct);
            totalAmount += scannedProduct.getPrice();

            saleDisplay.display(MessageFactory.productInfo(scannedProduct));

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

        if (!productInfo.isPresent()) {
            saleDisplay.display(MessageFactory.productNotFound());
            return;
        }

        if (!isProductInShoppingCart(productInfo.get())) {
            saleDisplay.display(MessageFactory.productNotInShoppingCart());
            return;
        }

        shoppingCart.remove(productInfo.get());
        totalAmount -= productInfo.get().getPrice();

    }

    private boolean isProductInShoppingCart(ProductInfo productInfo) {
        return shoppingCart.contains(productInfo);
    }
}
