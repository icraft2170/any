package me.hero;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PasswordValidatorTest {

  @Test
  @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
  void validatePasswordTest() {
    assertThatCode(() -> PasswordValidator.validate("serverwizard"))
        .doesNotThrowAnyException();
  }

  @Test
  @DisplayName("비밀번호가 8자 미만, 12자 초과인경우 IllegalArgumentException 발생")
  @ParameterizedTest
  @ValueSource(strings = {"abcdefg", "abcdefghijkl"})
  void validatePasswordTest2(String password) {
    String exceptionMessage = "비밀번호는 최소 8자 이상 12자 이하여야 한다.";
    assertThatCode(() -> PasswordValidator.validate(password))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(exceptionMessage);
  }

}
