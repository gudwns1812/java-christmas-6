package christmas.view;

import christmas.domain.Badge;
import christmas.domain.Money;
import java.util.Optional;

public class OutputView {
    private static final String GREETING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String READ_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String MENU_INFO = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String EVENT_INFO = "12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private static final String PRESENT = "<증정 메뉴>";
    private static final String DISCOUNT_PRICE = "<총 혜택 금액>";
    private static final String TOTAL_PRICE = "<할인 후 예상 결제 금액>";
    private static final String BADGE = "<12월 이벤트 배지>";

    public static void printGreeting() {
        System.out.println(GREETING);
    }

    public static void printDate() {
        System.out.println(READ_DATE);
    }

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printMenu() {
        System.out.println(MENU_INFO);
    }

    public static void printEventAnnounce() {
        System.out.println(EVENT_INFO);
    }

    public static void printResult(Money original, Money total, Optional<Badge> badge) {
        System.out.println(BEFORE_DISCOUNT);
        System.out.println(original.getValue() + "원");

        System.out.println(PRESENT);
        String presentAnswer = "없음";

        if (original.isGreaterThan(Money.won(120_000))) {
            presentAnswer = "샴페인 1개";
        }
        System.out.println(presentAnswer);

        System.out.println(DISCOUNT_PRICE);
        System.out.println(original.minus(total).getValue() + "원");

        System.out.println(TOTAL_PRICE);
        System.out.println(total.getValue() + "원");

        System.out.println(BADGE);
        String isBadge = "없음";

        if (badge.isPresent()) {
            isBadge = String.valueOf(badge.get().getName());
        }
    }
}
