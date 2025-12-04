package christmas.domain;

public class Menu {
    private final Money fee;
    private final DiscountPolicy discountPolicy;

    public Menu(Money fee, DiscountPolicy discountPolicy) {
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateOriginalFee(int quantity) {
        return fee.multiple(quantity);
    }
}
