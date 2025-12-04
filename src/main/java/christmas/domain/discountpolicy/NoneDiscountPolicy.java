package christmas.domain.discountpolicy;

import christmas.domain.DiscountPolicy;
import christmas.domain.Money;
import java.time.LocalDate;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money apply(LocalDate date, int quantity) {
        return Money.ZERO;
    }
}
