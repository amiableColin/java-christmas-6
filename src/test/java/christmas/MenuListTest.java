package christmas;

import christmas.entities.MenuList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MenuListTest {
    @DisplayName("getTotalPrice를 호출했을 때 합산된 메뉴 금액을 반환한다.")
    @Test
    public void totalPrice() {
        // given
        String str = "초코케이크-3,레드와인-1";
        final int EXPECTED_RESULT = 105_000;

        // when
        MenuList menuList = MenuList.from(str);

        // then
        assertThat(menuList.getTotalPrice()).isEqualTo(EXPECTED_RESULT);
    }
    @DisplayName("중복된 메뉴가 입력되었을 때, 예외가 발생한다.")
    @Test
    public void duplicateMenu() {
        String str = "초코케이크-3,초코케이크-1";
        assertThatThrownBy(() -> MenuList.from(str)).isInstanceOf(IllegalArgumentException.class);
    }
}
