package software.craftsmanship.serbia;

public interface PointOfSale {

    /**
     * Prints name and price of scanned product to the Console.
     *
     * @param barcode - Scanned product barcode
     */
    void onBarcode(String barcode);


    /**
     * Returns message with sum of prices of scanned products.
     *
     * @return formatted, output-ready message representing total price of the sale
     */
    String total();

    /**
     * Removes previously scanned product from current sale.
     *
     * Note: This is bonus method. Leave it to the end.
     * @param barcode - Scanned product barcode
     */
    void onBarcodeRemove(String barcode);

}
