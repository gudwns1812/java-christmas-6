package christmas.factory;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import christmas.domain.Menu;
import christmas.domain.discountcondition.WeekDiscountCondition;
import christmas.domain.discountpolicy.FixDiscountPolicy;
import christmas.domain.discountpolicy.NoneDiscountPolicy;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MenuFactory {
    private final Map<String, Menu> menuBoard;

    public MenuFactory() {
        menuBoard = Map.ofEntries(
                Map.entry("양송이수프", new Menu(6_000, new NoneDiscountPolicy())),
                Map.entry("타파스", new Menu(5_500, new NoneDiscountPolicy())),
                Map.entry("시저샐러드", new Menu(8_000, new NoneDiscountPolicy())),
                Map.entry("티본스테이크", new Menu(55_000, new FixDiscountPolicy(2023,
                        new WeekDiscountCondition(List.of(FRIDAY, SATURDAY))))),
                Map.entry("바비큐립", new Menu(54_000, new FixDiscountPolicy(2023,
                        new WeekDiscountCondition(List.of(FRIDAY, SATURDAY))))),
                Map.entry("해산물파스타", new Menu(35_000, new FixDiscountPolicy(2023,
                        new WeekDiscountCondition(List.of(FRIDAY, SATURDAY))))),
                Map.entry("크리스마스파스타", new Menu(25_000, new FixDiscountPolicy(10_000,
                        new WeekDiscountCondition(List.of(FRIDAY, SATURDAY))))),
                Map.entry("초코케이크", new Menu(15_000, new FixDiscountPolicy(2023,
                        new WeekDiscountCondition(List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY))))),
                Map.entry("아이스크림", new Menu(5_000, new FixDiscountPolicy(2023,
                        new WeekDiscountCondition(List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY))))),
                Map.entry("제로콜라", new Menu(3_000, new NoneDiscountPolicy())),
                Map.entry("레드와인", new Menu(60_000, new NoneDiscountPolicy())),
                Map.entry("샴페인", new Menu(25_000, new NoneDiscountPolicy()))
        );
    }

    public Optional<Menu> findMenuByName(String name) {
        return Optional.ofNullable(menuBoard.get(name));
    }
}
