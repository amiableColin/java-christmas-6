package christmas.entities.benefit;

public class SpecialBenefit {
    private final int dDay;

    public SpecialBenefit(int dDay) {
        this.dDay = dDay;
    }

    public int getBenefitPrice() {
        boolean isSpecialDay = this.dDay % 7 == 3 || this.dDay == 25;
        if (!isSpecialDay) {
            return 0;
        }
        return 1_000;
    }
}
