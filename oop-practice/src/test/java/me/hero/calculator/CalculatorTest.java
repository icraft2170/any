package me.hero.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;
import me.hero.calculator.operator.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {
  @ParameterizedTest
  @MethodSource("formulaAndResult")
  @DisplayName("덧셈, 뺄셈, 곱셈, 나눗셈 연산을 정상적으로 시행한다.")
  void calculatorTest(int operand1, String operator, int operand2, int expectedResult) {
    //when
    int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
    //then
    assertThat(result).isEqualTo(expectedResult);
  }

  private static Stream<Arguments> formulaAndResult() {
    return Stream.of(
        arguments(1, "+", 2, 3),
        arguments(1, "-", 2, -1),
        arguments(4, "*", 2, 8),
        arguments(4, "/", 2, 2)
    );
  }
}
