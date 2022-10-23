package me.hero.customer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CookTest {

  @Test
  @DisplayName("요리 생성한다.")
  void createTest() {
    assertThatCode(() -> new Cook("만두국", 6000))
        .doesNotThrowAnyException();

  }
}
