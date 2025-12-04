package christmas.domain.discountpolicy;

import christmas.domain.DiscountCondition;
import christmas.domain.DiscountPolicy;
import christmas.domain.Money;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FixDiscountPolicy implements DiscountPolicy {
    private final Money discount;
    private final List<DiscountCondition> conditions;

    public FixDiscountPolicy(int discount, DiscountCondition... conditions) {
        this.discount = Money.won(discount);
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money apply(LocalDate date, int quantity) {
        if (conditions.stream().allMatch(condition -> condition.isSatisfiedBy(date))) {
            return discount.multiple(quantity);
        }

        return Money.ZERO;
    }
}
