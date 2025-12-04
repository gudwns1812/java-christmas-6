package christmas.domain;

public class MenuDetail {
    private final Menu menu;
    private final int quantity;

    public MenuDetail(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Money getOriginalFee() {
        return menu.calculateOriginalFee(quantity);
    }
}
