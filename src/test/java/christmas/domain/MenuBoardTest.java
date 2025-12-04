package christmas.domain;

import christmas.domain.discountpolicy.FakeDiscountPolicy;
import java.time.LocalDate;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuBoardTest {

    @Test
    void 각_메뉴의_가격을_합산한다() {
        //given
        MenuDetail soup = new MenuDetail(new Menu(6_000, new FakeDiscountPolicy()), 1);
        MenuDetail tapas = new MenuDetail(new Menu(5_500, new FakeDiscountPolicy()), 2);
        Bill bill = new Bill(LocalDate.now(), List.of(soup, tapas));
        //when
        Money money = bill.calculateOriginalFee();
        //then
        Assertions.assertThat(money.getValue())
                .isEqualTo(17_000);
    }
}
