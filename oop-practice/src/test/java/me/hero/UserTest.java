package me.hero;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

  @Test
  @DisplayName("패스워드를 초기화한다.")
  void passwordTest() {
    //given
    User user = new User();
    //when
    user.initPassword(new CorrectFixedPasswordGenerator());
    //then
    assertThat(user.getPassword()).isNotNull();
  }


  @Test
  @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화되지 않음.")
  void passwordTest2() {
    //given
    User user = new User();

    //when
    user.initPassword(new WrongFixedPasswordGenerator());

    //then
    assertThat(user.getPassword()).isNull();
  }



}