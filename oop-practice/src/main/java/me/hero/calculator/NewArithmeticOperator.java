package me.hero.calculator;

import me.hero.calculator.operator.PositiveNumber;

public interface NewArithmeticOperator {
  boolean supports(String operator);
  int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
