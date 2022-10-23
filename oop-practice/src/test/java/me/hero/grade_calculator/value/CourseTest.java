package me.hero.grade_calculator.value;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CourseTest {

  @Test
  @DisplayName("과목(코스)를 생성한다.")
  void createTest() {
      assertThatCode(() -> new Course("OOP", 3, "A+"))
          .doesNotThrowAnyException();
  }
}
