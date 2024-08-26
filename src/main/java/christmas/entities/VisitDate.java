package christmas.entities;

public class VisitDate {
    private int dDay;

    public VisitDate(int dDay) {
        validateNumberRange(dDay);
        this.dDay = dDay;
    }

    public static VisitDate from(String dDay) {
        validateIsPositiveInteger(dDay);
        return new VisitDate(Integer.parseInt(dDay));
    }

    private static void validateIsPositiveInteger(String dDay) {
        boolean isPositiveInteger = dDay.chars().allMatch(c -> 0 <= c - '0' && c - '0' <= 9);
        if (!isPositiveInteger) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private void validateNumberRange(int dDay) {
        boolean isValidRange = 0 < dDay && dDay < 32;
        if (!isValidRange) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
