package software.craftsmanship.serbia.impl.display.message;

import software.craftsmanship.serbia.impl.domain.money.*;

import java.util.*;

class TotalMessage implements Message {

    private final MoneyAmount totalAmount;

    TotalMessage(MoneyAmount totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalMessage that = (TotalMessage) o;
        return Objects.equals(totalAmount, that.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalAmount);
    }

    @Override
    public String toString() {
        return "TotalMessage{" +
                "totalAmount=" + totalAmount +
                '}';
    }

    @Override
    public String getFormattedMessage() {
        // This should probably come from i18n file
        return String.format("Total: %.2f", totalAmount.getAmount());
    }
}
