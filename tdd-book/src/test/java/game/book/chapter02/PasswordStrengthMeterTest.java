package game.book.chapter02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {
  private PasswordStrengthMeter meter = new PasswordStrengthMeter();

  @Test
  void 비밀번호_강도가_강함일_때() {
    assertStrength("ab12!@AB", PasswordStrength.STRONG);
    assertStrength("abc1!Add", PasswordStrength.STRONG);
  }


  @Test
  void 길이외에_모든조건_충족해_노말일_때() {
    assertStrength("ab12!@A", PasswordStrength.NORMAL);
    assertStrength("Ab12!c", PasswordStrength.NORMAL);
  }

  @Test
  void 숫자포함외_모든조건_충족해_노말일_때() {
    assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
  }

  @Test
  void 비밀번호가_없는_경우() {
    assertStrength(null, PasswordStrength.INVALID);
  }

  @Test
  void 비밀번호가_비어있는_경우() {
    assertStrength("", PasswordStrength.INVALID);
  }

  @Test
  void 대문자포함외_모든조건_충족해_노말일_때() {
    assertStrength("ab12!@df", PasswordStrength.NORMAL);
  }

  @Test
  void 길이가_8글자_이상조건만_충족해_약함일_때() {
    assertStrength("abdefghi", PasswordStrength.WEEK);
  }

  @Test
  void 숫자포함_조건만_충족해_약함일_때() {
    assertStrength("12345", PasswordStrength.WEEK);
  }

  @Test
  void 대문자포함_조건만_충족해_약함일_때() {
    assertStrength("ABZEF", PasswordStrength.WEEK);
  }

  @Test
  void 아무것도_충족하지_못한경우() {
    assertStrength("abc", PasswordStrength.WEEK);
  }

  private void assertStrength(String password, PasswordStrength strong) {
    PasswordStrength result = meter.meter(password);
    assertEquals(strong, result);
  }
}
