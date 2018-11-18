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
        shoppingCart = ShoppingCart.createEmptyShoppingCart();
    }

    @Override
    public void onBarcode(String barcode) {
        final Optional<ProductInfo> productInfo = catalog.getProductInfo(BarcodeFactory.from(barcode));

        if (productInfo.isPresent()) {

            final ProductInfo scannedProduct = productInfo.get();

            shoppingCart.getShoppingCart().add(scannedProduct);
            shoppingCart.setTotalAmount(shoppingCart.getTotalAmount() + scannedProduct.getPrice());

            saleDisplay.display(MessageFactory.productInfo(scannedProduct));

        } else {

            saleDisplay.display(MessageFactory.productNotFound());

        }
    }

    @Override
    public void total() {
        saleDisplay.display(MessageFactory.total(shoppingCart.getTotalAmount()));
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

        shoppingCart.getShoppingCart().remove(productInfo.get());
        shoppingCart.setTotalAmount(shoppingCart.getTotalAmount() - productInfo.get().getPrice());

    }

    private boolean isProductInShoppingCart(ProductInfo productInfo) {
        return shoppingCart.getShoppingCart().contains(productInfo);
    }
}
