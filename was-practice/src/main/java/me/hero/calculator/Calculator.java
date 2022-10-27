package me.hero.calculator;

import java.util.List;
import me.hero.calculator.operator.AdditionOperator;
import me.hero.calculator.operator.DivisionOperator;
import me.hero.calculator.operator.MultiplicationOperator;
import me.hero.calculator.operator.PositiveNumber;
import me.hero.calculator.operator.SubtractionOperator;

public class Calculator {
  private static final List<NewArithmeticOperator> operators = List.of(
      new AdditionOperator(),
      new SubtractionOperator(),
      new MultiplicationOperator(),
      new DivisionOperator()
  );

  public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
//    return ArithmeticOperator.calculator(operand1, operator, operand2);
    return operators.stream()
        .filter(o -> o.supports(operator))
        .map(o -> o.calculate(operand1, operand2))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
  }

}
