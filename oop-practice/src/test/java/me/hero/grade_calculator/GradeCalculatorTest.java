package me.hero.grade_calculator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import me.hero.grade_calculator.value.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {
    // 학점 계산기 도메인 : 이수한 과목, 학점 계산기, 학생 , 학생의 점수
    // 이수한 과목 : 수업 종류
    // 이수한 과목을 전달하여 평균 학점 계산을 요청  Client -> 학점 계산기 -> 과목들(일급 컬렉션) -> 학점 응답


  @Test
  @DisplayName("평균 학점을 계산한다.")
  void calculateGradeTest() {
    //given
    List<Course> courses = List.of(
        new Course("OOP", 3, "A+"),
        new Course("자료구조", 3, "A+")
    );
    //when
    GradeCalculator gradeCalculator = new GradeCalculator(courses);
    double gradeResult = gradeCalculator.calculateGrade();
    //then
    assertThat(gradeResult).isEqualTo(4.5);
  }

}
