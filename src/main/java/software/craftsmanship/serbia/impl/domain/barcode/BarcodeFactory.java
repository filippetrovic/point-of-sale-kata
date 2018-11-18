package software.craftsmanship.serbia.impl.domain.barcode;

public class BarcodeFactory {

    private static final String BARCODE_REGEX = "[0-9]+";

    public static Barcode from(String code) {
        validate(code);

        return new Barcode(code);
    }

    private static void validate(String code) {
        if (!code.matches(BARCODE_REGEX)) {
            throw new IllegalArgumentException(code + " is not a valid barcode");
        }
    }

}
