package christmas.domain;

import java.time.LocalDate;
import java.util.List;

public class Bill {
    private final List<MenuDetail> menus;
    private final LocalDate date;

    public Bill(LocalDate date, List<MenuDetail> menus) {
        this.date = date;
        this.menus = menus;
    }

    public Money calculateOriginalFee() {
        return menus.stream()
                .map(MenuDetail::getOriginalFee)
                .reduce(Money::plus)
                .orElseGet(() -> Money.ZERO);
    }

    public Money calculateTotalFee(List<DiscountPolicy> policies) {
        Money original = calculateOriginalFee();

        if (original.isLessThan(Money.won(10_000))) {
            return original;
        }

        Money menuDiscount = calculateMenuDiscount();
        Money discount = calculateBillDiscount(policies);

        return original.minus(menuDiscount).minus(discount);
    }

    public Money calculateMenuDiscount() {
        return menus.stream()
                .map(menu -> menu.calculateFee(date))
                .reduce(Money.ZERO, Money::plus);
    }

    public Money calculateBillDiscount(List<DiscountPolicy> policies) {
        return policies.stream()
                .map(policy -> policy.apply(date, 1))
                .reduce(Money.ZERO, Money::plus);
    }

    public LocalDate getDate() {
        return date;
    }
}
