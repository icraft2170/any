package game.book.chapter02;

public enum PasswordStrength {
  INVALID, WEEK, NORMAL, STRONG;
  public static PasswordStrength of(int metCounts) {
    if (metCounts <= 1) return PasswordStrength.WEEK;
    if (metCounts == 2) return PasswordStrength.NORMAL;
    return PasswordStrength.STRONG;
  }
}
