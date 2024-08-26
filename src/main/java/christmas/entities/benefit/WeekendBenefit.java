package christmas.entities.benefit;

import christmas.entities.Menu;

import java.util.Map;

public class WeekendBenefit {
    private final Map<String, Integer> menuList;
    private final int dDay;
    public WeekendBenefit(Map<String, Integer> menuList, int dDay) {
        this.menuList = menuList;
        this.dDay = dDay;
    }

    public int getBenefitPrice() {
        boolean isWeekend = this.dDay % 7 == 1 || this.dDay % 7 == 2;
        if (!isWeekend) {
            return 0;
        }
        return this.menuList.keySet().stream()
                .filter(key -> Menu.menuCategory.get("메인").contains(key))
                .mapToInt(menuList::get).sum() * 2023;
    }
}
