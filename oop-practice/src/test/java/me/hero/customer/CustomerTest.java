package me.hero.customer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 1. 도메인을 구성하는 객체
 * - 주문, 음식, 손님, 메뉴판, 요리사
 * 2. 객체들 간의 관계
 * - 손님은 메뉴판을 보고 요리를 요청
 * - 요리사가 요청을 받아 요리를 만든다.
 * - 요리사가 음식을 만들어 손님에게 제공한다.
 * 3. 추상화
 * - 메뉴, 요리, 메뉴판, 손님
 */

public class CustomerTest {

  @Test
  @DisplayName("손님이 메뉴에서 선택해 요리를 주문한다.")
  void orderTest() {
    Customer customer = new Customer();
    Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉명", 6000)));
    Cooker cooker = new Cooker();

    assertThatCode(() -> customer.order("돈까스", menu, cooker))
        .doesNotThrowAnyException();
  }
}
