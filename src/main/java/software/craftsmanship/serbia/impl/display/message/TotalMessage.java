package software.craftsmanship.serbia.impl.display.message;

import java.util.*;

class TotalMessage implements Message {

    private final double totalAmount;

    TotalMessage(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalMessage that = (TotalMessage) o;
        return Double.compare(that.totalAmount, totalAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalAmount);
    }

    @Override
    public String getFormattedMessage() {
        // This should probably come from i18n file
        return String.format("Total: %.2f", totalAmount);
    }
}
