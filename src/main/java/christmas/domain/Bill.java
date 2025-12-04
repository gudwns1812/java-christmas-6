package christmas.domain;

import java.util.List;

public class Bill {
    private final List<MenuDetail> menus;

    public Bill(List<MenuDetail> menus) {
        this.menus = menus;
    }

    public Money calculateOriginalFee() {
        return menus.stream()
                .map(MenuDetail::getOriginalFee)
                .reduce(Money::plus)
                .orElseGet(() -> Money.ZERO);
    }

    public Money calculateTotalFee() {
        return Money.ZERO;
    }
}
