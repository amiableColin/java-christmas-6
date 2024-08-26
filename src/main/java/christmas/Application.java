package christmas;
import christmas.entities.MenuList;
import christmas.entities.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        VisitDate visitDate = inputView.readDate();
        MenuList menuList = inputView.readOrder();
        outputView.printOrder(menuList.getMenuList());
        outputView.printTotalPrice(menuList.getTotalPrice());
        outputView.printPromotion(menuList.getTotalPrice());
    }

}
