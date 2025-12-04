package christmas.domain;

import java.time.LocalDate;

public class Menu {
    private final Money fee;
    private final DiscountPolicy discountPolicy;

    public Menu(int fee, DiscountPolicy discountPolicy) {
        this.fee = Money.won(fee);
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money getOriginalFee(int quantity) {
        return fee.multiple(quantity);
    }

    public Money calculateFee(LocalDate date, int quantity) {
        return discountPolicy.apply(date, quantity);
    }
}
