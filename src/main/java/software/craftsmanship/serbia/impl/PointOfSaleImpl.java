package software.craftsmanship.serbia.impl;

import software.craftsmanship.serbia.*;
import software.craftsmanship.serbia.impl.catalog.*;
import software.craftsmanship.serbia.impl.display.*;
import software.craftsmanship.serbia.impl.display.message.*;
import software.craftsmanship.serbia.impl.domain.barcode.*;
import software.craftsmanship.serbia.impl.domain.cart.*;

import java.util.*;

public class PointOfSaleImpl implements PointOfSale {

    private SaleDisplay saleDisplay;
    private Catalog catalog;
    private ShoppingCart shoppingCart;

    public PointOfSaleImpl(SaleDisplay saleDisplay, Catalog catalog) {
        this.saleDisplay = saleDisplay;
        this.catalog = catalog;
        shoppingCart = SimpleShoppingCart.createEmptyShoppingCart();
    }

    @Override
    public void onBarcode(String barcode) {
        final Optional<ProductInfo> productInfo = catalog.getProductInfo(BarcodeFactory.from(barcode));

        if (productInfo.isPresent()) {
            shoppingCart.put(productInfo.get());
            saleDisplay.display(MessageFactory.productInfo(productInfo.get()));
        } else {
            saleDisplay.display(MessageFactory.productNotFound());
        }
    }

    @Override
    public void total() {
        saleDisplay.display(MessageFactory.total(shoppingCart.getTotal()));
    }

    @Override
    public void onBarcodeRemove(String barcode) {
        final Optional<ProductInfo> productInfo = catalog.getProductInfo(BarcodeFactory.from(barcode));

        if (!productInfo.isPresent()) {
            saleDisplay.display(MessageFactory.productNotFound());
            return;
        }

        try {
            shoppingCart.remove(productInfo.get());
        } catch (ProductNotFound productNotFound) {
            saleDisplay.display(MessageFactory.productNotInShoppingCart());
        }

    }

}
