package christmas.entities;

import java.util.Map;
import java.util.regex.Pattern;

public class Menu {
    private static final Map<String, Integer> priceOfMenu = Map.ofEntries(Map.entry("양송이수프", 6_000), Map.entry("타파스", 5_500), Map.entry("시저샐러드", 8_000),
            Map.entry("티본스테이크", 55_000), Map.entry("바비큐립", 54_000), Map.entry("해산물파스타", 35_000), Map.entry("크리스마스파스타", 25_000),
            Map.entry("초코케이크", 15_000), Map.entry("아이스크림", 5_000), Map.entry("제로콜라", 3_000), Map.entry("레드와인", 60_000), Map.entry("샴페인", 25_000));
    private final int count;
    private final String menu;

    public Menu(String menu, int count) {
        validateIsMenu(menu);
        validateIsNaturalNumber(count);
        this.count = count;
        this.menu = menu;
    }

    public static Menu from(String orderString) {
        validateHasHyphen(orderString);
        validateIsInteger(orderString.split("-")[1]);
        String menuName = orderString.split("-")[0];
        int count = Integer.parseInt(orderString.split("-")[1]);
        return new Menu(menuName, count);
    }

    private static void validateIsInteger(String str) {
        boolean isInteger = str.chars().allMatch(c -> 0 <= c - '0' && c - '0' <= 9);
        if (!isInteger) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public int getPrice() {
        return this.priceOfMenu.get(menu) * this.count;
    }

    private static void validateHasHyphen(String str) {
        boolean hasOnlyHyphen = str.chars().filter(c -> c == '-').count() == 1;
        if (!hasOnlyHyphen) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateIsMenu(String menu) {
        boolean isMenu = Menu.priceOfMenu.containsKey(menu);
        if (!isMenu) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateIsNaturalNumber(int number) {
        boolean isNatural = 0 < number;
        if(!isNatural) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
