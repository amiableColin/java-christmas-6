package christmas.entities.benefit;

import christmas.entities.VisitDate;

public class ChrismasBenefit {
    private final int dDay;

    private static final int basePrice = 1000;

    public ChrismasBenefit(int dDay) {
        this.dDay = dDay;
    }

    public int getBenefitPrice() {
        if (this.dDay < 25) {
            return ChrismasBenefit.basePrice + (this.dDay - 1) * 100;
        }
        return 0;
    }
}
