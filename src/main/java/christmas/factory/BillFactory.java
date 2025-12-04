package christmas.factory;

import static christmas.util.NumberValidator.validateNumber;

import christmas.domain.Bill;
import christmas.domain.Menu;
import christmas.domain.MenuDetail;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BillFactory {
    private static final String MENU_DELIMITER = ",";
    private static final String NAME_DELIMITER = "-";
    private static final int STRING_INDEX = 0;
    private static final int NUMBER_INDEX = 1;
    private static final MenuFactory factory = new MenuFactory();

    public static Bill createBill(String input) {
        List<String> menus = delimitMenu(input);
        List<List<String>> menuDetails = delimitName(menus);

        duplicateMenu(menuDetails);
        validMenuNumber(menuDetails);

        return makeBill(menuDetails);
    }

    private static List<String> delimitMenu(String input) {
        return List.of(input.split(MENU_DELIMITER));
    }

    private static List<List<String>> delimitName(List<String> menus) {
        List<List<String>> menuDetails = new ArrayList<>();

        for (String menu : menus) {
            validateMenuFormat(menu);

            List<String> menuDetail = List.of(menu.split(NAME_DELIMITER));
            validateNumber(menuDetail.get(NUMBER_INDEX));

            menuDetails.add(menuDetail);
        }

        return menuDetails;
    }

    private static void validateMenuFormat(String menu) {
        if (menu.split(NAME_DELIMITER).length != 2) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void duplicateMenu(List<List<String>> menuDetails) {
        Set<String> validator = new HashSet<>();

        menuDetails.forEach(menuDetail -> validator.add(menuDetail.get(STRING_INDEX)));

        if (validator.size() != menuDetails.size()) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void validMenuNumber(List<List<String>> menuDetails) {
        int menuCount = menuDetails.stream()
                .mapToInt(menuDetail -> parseInt(menuDetail.get(NUMBER_INDEX)))
                .map(BillFactory::validateNegative)
                .reduce(0, Integer::sum);

        if (menuCount > 20) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static int parseInt(String number) {
        validateNumber(number);

        return Integer.parseInt(number);
    }

    private static int validateNegative(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        return number;
    }

    private static Bill makeBill(List<List<String>> menuDetails) {
        List<MenuDetail> menus = new ArrayList<>();
        menuDetails.forEach(menuDetail -> menus.add(createMenuDetail(menuDetail)));

        return new Bill(menus);
    }

    private static MenuDetail createMenuDetail(List<String> menuDetail) {
        Menu menu = factory.findMenuByName(menuDetail.get(STRING_INDEX))
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요."));
        int quantity = Integer.parseInt(menuDetail.get(NUMBER_INDEX));

        return new MenuDetail(menu, quantity);
    }
}
