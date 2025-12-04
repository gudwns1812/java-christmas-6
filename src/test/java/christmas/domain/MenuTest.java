package christmas.domain;

import christmas.factory.MenuFactory;
import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void 메뉴_할인_금액_계산() {
        //given
        MenuFactory factory = new MenuFactory();
        LocalDate date = LocalDate.of(2023, 12, 2);
        //when
        Menu menu = factory.findMenuByName("바베큐립").orElseThrow(() -> new RuntimeException());
        //then
        Assertions.assertThat(menu.calculateFee(date, 1))
                .isEqualTo(Money.won(2023));
    }

}
