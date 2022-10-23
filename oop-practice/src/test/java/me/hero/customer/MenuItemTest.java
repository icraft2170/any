package me.hero.customer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuItemTest {
  @Test
  @DisplayName("메뉴를 생성한다.")
  void createTest() {
    assertThatCode(() -> new MenuItem("만두", 6000))
        .doesNotThrowAnyException();
  }
}
