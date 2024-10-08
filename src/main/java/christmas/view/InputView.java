package christmas.view;

import christmas.entities.MenuList;
import christmas.entities.VisitDate;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public VisitDate readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        while (true) {
            try {
                return VisitDate.from(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public MenuList readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        while (true) {
            try {
                return MenuList.from(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
