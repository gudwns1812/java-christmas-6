package christmas.factory;

import christmas.domain.Menu;
import christmas.domain.Money;
import christmas.domain.discountpolicy.MenuDiscountPolicy;
import java.util.Map;
import java.util.Optional;

public class MenuFactory {
    private final Map<String, Menu> menuBoard;

    public MenuFactory() {
        menuBoard = Map.of(
                "양송이수프", new Menu(Money.won(6_000), new MenuDiscountPolicy()),
                "타파스", new Menu(Money.won(5_500), new MenuDiscountPolicy())
        );
    }

    public Optional<Menu> findMenuByName(String name) {
        return Optional.ofNullable(menuBoard.get(name));
    }
}
