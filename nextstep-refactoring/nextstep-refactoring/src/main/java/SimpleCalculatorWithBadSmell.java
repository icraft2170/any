import java.util.*;

public class SimpleCalculatorWithBadSmell {

  public static void main(String[] args) {
    final Scanner reader = new Scanner(System.in);
    String input = reader.nextLine();
    StringBuilder inputTemp = new StringBuilder();
    Integer result = null;



    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == ' ') {
        continue;
      }
      inputTemp.append(input.charAt(i));
    }

    StringBuilder firstInputValue = new StringBuilder();
    StringBuilder secondInputValue = new StringBuilder();

    char operator = extractOperator(inputTemp, firstInputValue, secondInputValue);
    int firstOperand = convertOperand(firstInputValue);
    int secondOperand = convertOperand(secondInputValue);
    result = calculate(firstOperand, secondOperand, operator, result);
    printResult(result);

    reader.close();
  }

  private static void printResult(Integer result) {
    MoneyChangingMachine moneyChangingMachine = new MoneyChangingMachine();
    int displayMode = 0;
    switch (displayMode) {
      case 0:
        System.out.print(moneyChangingMachine.exchangeWonToDecimal(result));
        break;
      case 1:
        System.out.print(moneyChangingMachine.exchangeWonToBinary(result));
        break;
      case 2:
        System.out.print(moneyChangingMachine.exchangeWonToHex(result));
        break;
      case 3:
        System.out.print(moneyChangingMachine.exchangeWonToDollarToDecimal(result));
        break;
      case 4:
        System.out.print(moneyChangingMachine.exchangeWonToDollarToBinary(result));
        break;
      case 5:
        System.out.print(moneyChangingMachine.exchangeWonToDollarToHex(result));
        break;
    }
  }

  private static int convertOperand(StringBuilder input) {
    int operand = 0;
    for (int i = input.length() - 1; i >= 0; i--) {
      operand += (input.charAt(i) - '0') * (int)Math.pow(10, i);
    }
    return operand;
  }

  private static Integer calculate(int firstOperand, int secondOperand, char operator,
      Integer result) {
    if (operator == '+') {
      result = firstOperand + secondOperand;
    } else if (operator == '-') {
      result = firstOperand - secondOperand;
    } else if (operator == '*') {
      result = firstOperand * secondOperand;
    } else if (operator == '/') {
      result = firstOperand / secondOperand;
    }
    return result;
  }

  private static char extractOperator(StringBuilder temp, StringBuilder firstInput, StringBuilder secondInput) {
    char operator = ' ';
    int i;
    for (i = 0; i < temp.length(); i++) {
      if (temp.charAt(i) == '+') {
        return temp.charAt(i);
      } else if (temp.charAt(i) == '-') {
        return temp.charAt(i);
      } else if (temp.charAt(i) == '*') {
        return temp.charAt(i);
      } else if (temp.charAt(i) == '/') {
        return temp.charAt(i);
      } else if (operator == ' ') {
        firstInput.append(temp.charAt(i));
      } else if (operator != ' ') {
        secondInput.append(temp.charAt(i));
      }
    }
    return operator;
  }
}