package christmas.entities;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MenuList {
    private final List<Menu> menuList;

    public MenuList(List<String> menuList) {
        this.menuList = menuList.stream().map(Menu::from).toList();
        validateDuplicateMenu();
    }
    public static MenuList from(String str) {
        return new MenuList(Arrays.stream(str.split(",")).toList());
    }

    public int getTotalPrice() {
        return menuList.stream().mapToInt(Menu::getPrice).sum();
    }

    private void validateDuplicateMenu() {
        boolean isDuplicated = this.menuList.stream().map(Menu::getMenuName).collect(Collectors.toSet()).size() != this.menuList.size();
        if (isDuplicated) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public Map<String, Integer> getMenuList() {
        return this.menuList.stream().collect(Collectors.toMap(Menu::getMenuName, Menu::getCount));
    }
}
