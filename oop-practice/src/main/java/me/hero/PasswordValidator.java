package me.hero;

public class PasswordValidator {
  public static final String WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE = "비밀번호는 최소 8자 이상 12자 이하여야 한다.";

  public static void validate(String password)  {
    int passwordLength = password.length();
    if (passwordLength < 8 || passwordLength > 12) {
      throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
    }
  }
  
}
