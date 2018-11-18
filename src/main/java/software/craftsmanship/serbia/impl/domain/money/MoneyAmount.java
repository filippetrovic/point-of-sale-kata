package software.craftsmanship.serbia.impl.domain.money;

import java.util.*;

public class MoneyAmount {

    private final Currency currency;
    private final double amount;

    public static MoneyAmount serbianDinars(double amount) {
        return new MoneyAmount(Currency.getInstance("RSD"), amount);
    }

    private MoneyAmount(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public MoneyAmount plus(MoneyAmount another) {
        if (!currency.equals(another.currency)) {
            throw new IllegalArgumentException(
                    String.format("Can't add %s to %s", another, this));
        }

        return new MoneyAmount(currency, amount + another.amount);
    }

    public MoneyAmount minus(MoneyAmount another) {
        if (!currency.equals(another.currency)) {
            throw new IllegalArgumentException(
                    String.format("Can't subtract %s from %s", another, this));
        }

        return new MoneyAmount(currency, amount - another.amount);
    }

    @Override
    public String toString() {
        return "MoneyAmount{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyAmount that = (MoneyAmount) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }

    public double getAmount() {
        return amount;
    }
}
