package christmas.view;

import christmas.entities.GiveawayPromotion;
import christmas.entities.Menu;
import christmas.entities.MenuList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public OutputView() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printOrder(Map<String, Integer> menuList) {
        String orderString = menuList.keySet().stream().map(key -> key + " " + menuList.get(key) + "개").collect(Collectors.joining("\n"));

        System.out.println("\n<주문 메뉴>");
        System.out.println(orderString);
    }

    public void printTotalPrice(int price) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(String.format("%,d", price) + "원");
    }

    public void printPromotion(int price) {
        System.out.println("\n<증정 메뉴>");
        GiveawayPromotion giveawayPromotion = new GiveawayPromotion(price);
        if (giveawayPromotion.isPromotion()) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }
}
