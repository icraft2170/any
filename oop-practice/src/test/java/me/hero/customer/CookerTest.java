package me.hero.customer;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CookerTest {

  @Test
  @DisplayName("메뉴에 해당하는 음식을 만든다.")
  void makeCookTest() {
    Cooker cooker = new Cooker();
    MenuItem 돈까스 = new MenuItem("돈까스", 5000);

    Cook cook = cooker.makeCook(돈까스);

    assertThat(cook).isEqualTo(new Cook("돈까스", 5000));
  }
}
