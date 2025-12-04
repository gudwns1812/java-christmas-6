package christmas.domain.discountcondition;

import christmas.domain.DiscountCondition;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class WeekDiscountCondition implements DiscountCondition {
    private final List<DayOfWeek> conditions;

    public WeekDiscountCondition(List<DayOfWeek> conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean isSatisfiedBy(LocalDate localDate) {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        return conditions.stream()
                .anyMatch(day -> day.equals(dayOfWeek));
    }
}
