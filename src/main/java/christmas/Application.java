package christmas;
import christmas.entities.GiveawayPromotion;
import christmas.entities.MenuList;
import christmas.entities.VisitDate;
import christmas.entities.benefit.ChrismasBenefit;
import christmas.entities.benefit.SpecialBenefit;
import christmas.entities.benefit.WeekdayBenefit;
import christmas.entities.benefit.WeekendBenefit;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

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

        ChrismasBenefit chrismasBenefit = new ChrismasBenefit(visitDate.getdDay());
        SpecialBenefit specialBenefit = new SpecialBenefit(visitDate.getdDay());
        WeekdayBenefit weekdayBenefit = new WeekdayBenefit(menuList.getMenuList(), visitDate.getdDay());
        WeekendBenefit weekendBenefit = new WeekendBenefit(menuList.getMenuList(), visitDate.getdDay());
        GiveawayPromotion giveawayPromotion = new GiveawayPromotion(menuList.getTotalPrice());
        outputView.printBenefit(Map.of("크리스마스 디데이 할인", chrismasBenefit.getBenefitPrice(),
                "평일 할인", weekdayBenefit.getBenefitPrice(), "주말 할인", weekendBenefit.getBenefitPrice(),
                "특별 할인", specialBenefit.getBenefitPrice(), "증정 이벤트", giveawayPromotion.getPrice()));
    }
}
