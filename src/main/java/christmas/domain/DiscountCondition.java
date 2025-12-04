package christmas.domain;

import java.time.LocalDate;

public interface DiscountCondition {

    boolean isSatisfiedBy(LocalDate localDate);
}
