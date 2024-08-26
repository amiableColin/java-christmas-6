package christmas.entities.benefit;

import christmas.entities.Menu;

import java.util.Map;

public class WeekdayBenefit {
    private final Map<String, Integer> menuList;
    private final int dDay;
    public WeekdayBenefit(Map<String, Integer> menuList, int dDay) {
        this.menuList = menuList;
        this.dDay = dDay;
    }

    private int getBenefitPrice() {
        boolean isWeekdays = this.dDay % 7 != 1 && this.dDay % 7 != 2;
        if (!isWeekdays) {
            return 0;
        }
        return this.menuList.keySet().stream()
                .filter(key -> Menu.menuCategory.get("디저트").contains(key))
                .mapToInt(menuList::get).sum() * 2023;
    }
}
