package me.hero;

public class CorrectFixedPasswordGenerator implements PasswordGeneratePolicy{

  @Override
  public String generatePassword() {
    return "abcdefgh";
  }
}
