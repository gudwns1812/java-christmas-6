package christmas.domain.discountcondition;

import christmas.domain.DiscountCondition;
import java.time.LocalDate;
import java.util.List;

public class DayDiscountCondition implements DiscountCondition {
    private final List<Integer> conditions;

    public DayDiscountCondition(List<Integer> conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean isSatisfiedBy(LocalDate localDate) {
        int day = localDate.getDayOfMonth();

        return conditions.stream().anyMatch(condition -> condition.equals(day));
    }
}
