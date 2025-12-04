package christmas.domain.discountpolicy;

import christmas.domain.Money;
import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ChrisMasDiscountPolicyTest {

    @Test
    void 크리스마스_할인_금액_계산() {
        //given
        LocalDate date = LocalDate.of(2023, 12, 3);
        ChrisMasDiscountPolicy policy = new ChrisMasDiscountPolicy();
        //when
        Money discount = policy.apply(date, 1);
        //then
        Assertions.assertThat(discount)
                .isEqualTo(Money.won(1200));
    }

}
