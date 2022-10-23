package me.hero.calculator.operator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {
  @ParameterizedTest
  @ValueSource(ints = {0, -1})
  void createTest() {
    assertThatCode(() -> new PositiveNumber(0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("0 또는 음수를 전달 할 수 없습니다.");
  }
}