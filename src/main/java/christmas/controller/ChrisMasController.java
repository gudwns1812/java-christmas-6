package christmas.controller;

import static christmas.util.NumberValidator.validateNumber;
import static christmas.view.InputView.readDate;
import static christmas.view.InputView.readMenu;
import static christmas.view.OutputView.printDate;
import static christmas.view.OutputView.printEventAnnounce;
import static christmas.view.OutputView.printGreeting;
import static christmas.view.OutputView.printMenu;
import static christmas.view.OutputView.printResult;

import christmas.domain.Badge;
import christmas.domain.Bill;
import christmas.domain.Money;
import christmas.domain.discountcondition.DayDiscountCondition;
import christmas.domain.discountpolicy.ChrisMasDiscountPolicy;
import christmas.domain.discountpolicy.FixDiscountPolicy;
import christmas.factory.BillFactory;
import christmas.view.OutputView;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class ChrisMasController {

    public void run() {
        int date = retryOnError(() -> {
            printGreeting();
            printDate();
            String dateInput = readDate();

            validateDate(dateInput);
            return Integer.valueOf(dateInput);
        });

        Bill menuBill = retryOnError(() -> {
            printMenu();
            String inputMenu = readMenu();

            Bill bill = BillFactory.createBill(date, inputMenu);
            printEventAnnounce();
            return bill;
        });

        Money original = menuBill.calculateOriginalFee();
        Money total = menuBill.calculateTotalFee(
                List.of(new ChrisMasDiscountPolicy(), new FixDiscountPolicy(1_000,
                        new DayDiscountCondition(List.of(3, 10, 17, 24, 25, 31))
                ))
        );

        Optional<Badge> badge = Badge.of(original.minus(total).getValue());
        printResult(original, total, badge);
    }

    private void validateDate(String date) {
        validateNumber(date);

        int dateNumber = Integer.parseInt(date);
        if (dateNumber < 1 || dateNumber > 31) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private <T> T retryOnError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
