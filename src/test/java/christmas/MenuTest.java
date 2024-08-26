package christmas;

import christmas.entities.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MenuTest {
    @DisplayName("존재하지 않는 메뉴를 입력 받았을 때, 예외를 반환한다.")
    @Test
    public void isExistingMenu() {
        assertThatThrownBy(() -> Menu.from("떡볶이-5")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자연수가 아닌 입력을 인자로 받았을 때, 예외를 반환한다.")
    @Test
    public void isNaturalNumber() {
        assertThatThrownBy(() -> Menu.from("초코케이크-3.5")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("여러 개의 하이푼이 인자로 들어왔을 때, 예외를 반환한다.")
    @Test
    public void isInteger() {
        assertThatThrownBy(() -> Menu.from("초코케이크--1")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("하이푼이 인자의 가장 앞으로 들어왔을 때, 예외를 반환한다.")
    @Test
    public void isFrontHyphen() {
        assertThatThrownBy(() -> Menu.from("-초코케이크5")).isInstanceOf(IllegalArgumentException.class);
    }
}
