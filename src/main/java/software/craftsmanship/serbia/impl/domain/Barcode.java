package software.craftsmanship.serbia.impl.domain;

import java.util.Objects;

public class Barcode {

    private String code;

    private Barcode(String code) {
        this.code = code;
    }

    public static Barcode from(String code) {
        return new Barcode(code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Barcode barcode = (Barcode) o;
        return Objects.equals(code, barcode.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Barcode{" +
             "code='" + code + '\'' +
             '}';
    }
}
