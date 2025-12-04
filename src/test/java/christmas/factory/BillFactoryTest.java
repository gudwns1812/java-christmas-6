package christmas.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.Bill;
import christmas.domain.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BillFactoryTest {

    @Test
    void 메뉴_입력값이_유효한지_검증한다() {
        //given
        String input = "양송이수프-1,타파스-2";
        //when
        Bill bill = BillFactory.createBill(1, input);
        //then
        assertThat(bill.calculateOriginalFee())
                .isEqualTo(Money.won(17_000));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "양송이스프-1,타파스-2", "양송이수프-0,타파스-2", "양송이수프-1, 타파스-2", "양송이수프-1,양송이수프-2", "양송이수프-15,타파스-10"
    })
    void 메뉴_입력값_예외_상황(String input) {
        assertThatThrownBy(() -> BillFactory.createBill(1, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 주문입니다");
    }
}
