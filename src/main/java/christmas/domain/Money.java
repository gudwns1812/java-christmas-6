package christmas.domain;

public class Money {
    public static final Money ZERO = Money.won(0);

    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public Money plus(Money other) {
        return new Money(value + other.value);
    }

    public Money minus(Money other) {
        return new Money(value - other.value);
    }

    public Money multiple(int number) {
        return new Money(value * number);
    }

    public int getValue() {
        return value;
    }

    public static Money won(int cash) {
        return new Money(cash);
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Money money)) {
            return false;
        }

        return value == money.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public boolean isLessThan(Money other) {
        return value < other.value;
    }

    public boolean isGreaterThan(Money other) {
        return value > other.value;
    }
}
