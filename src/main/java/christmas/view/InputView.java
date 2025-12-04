package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {
    private InputView() {
    }

    public static String readDate() {
        return Console.readLine();
    }

    public static String readMenu() {
        return Console.readLine();
    }
}
