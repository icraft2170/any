package me.hero.customer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {

  @DisplayName("메뉴판에서 주입받은 이름에 해당하는 메뉴를 반환")
  @Test
  void chooseTest() {
    Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉명", 6000)));

    MenuItem 돈까스 = menu.choose("돈까스");

    assertThat(돈까스).isEqualTo(new MenuItem("돈까스", 5000));
  }
}
