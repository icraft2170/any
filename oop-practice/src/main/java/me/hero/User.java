package me.hero;

public class User {

  private String password;

  public String getPassword() {
    return password;
  }

  public void initPassword(PasswordGeneratePolicy generator) {
    String password = generator.generatePassword();
    int length = password.length();
    if (length >= 8 && length <= 12) {
      this.password = password;
    }
  }

}
