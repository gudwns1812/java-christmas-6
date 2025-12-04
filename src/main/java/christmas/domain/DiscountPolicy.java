package christmas.domain;

import java.time.LocalDate;

public interface DiscountPolicy {

    Money apply(LocalDate date, int quantity);
}
