package christmas;

import christmas.entities.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class VisitDateTest {
    @DisplayName("유효한 숫자 입력이 들어왔는지 검증하여, 잘못된 입력이라면 예외를 반환한다.")
    @Test
    void positiveNumberTest() {
        String DATE = "-1";

        assertThatThrownBy(() -> VisitDate.from(DATE)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 범위의 숫자 입력이 들어왔는지 검증하여, 범위를 벗어났다면 예외를 반환한다.")
    @Test
    void numberRangeTest() {
        int DATE = 0;

        assertThatThrownBy(() -> new VisitDate(DATE)).isInstanceOf(IllegalArgumentException.class);
    }
}
