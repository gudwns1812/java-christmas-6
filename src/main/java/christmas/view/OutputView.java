package christmas.view;

public class OutputView {
    private static final String GREETING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String READ_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printGreeting() {
        System.out.println(GREETING);
    }

    public static void printDate() {
        System.out.println(READ_DATE);
    }

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
