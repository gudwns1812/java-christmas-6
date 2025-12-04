package christmas.domain.discountpolicy;

import christmas.domain.DiscountPolicy;
import christmas.domain.Money;
import java.time.LocalDate;

public class ChrisMasDiscountPolicy implements DiscountPolicy {
    private static final int STANDARD = 1000;
    private static final int ADD_DISCOUNT = 100;
    private static final int CHRISTMAS_DATE = 25;
    
    @Override
    public Money apply(LocalDate date, int quantity) {
        int day = date.getDayOfMonth();

        if (day > CHRISTMAS_DATE) {
            return Money.ZERO;
        }

        return Money.won(STANDARD + (day - 1) * ADD_DISCOUNT);
    }
}
