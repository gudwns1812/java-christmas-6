package christmas.domain;

import java.time.LocalDate;

public class MenuDetail {
    private final Menu menu;
    private final int quantity;

    public MenuDetail(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Money getOriginalFee() {
        return menu.getOriginalFee(quantity);
    }

    public Money calculateFee(LocalDate date) {
        return menu.calculateFee(date, quantity);
    }
}
