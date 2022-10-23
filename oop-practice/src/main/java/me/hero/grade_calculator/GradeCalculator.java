package me.hero.grade_calculator;

import java.util.List;
import me.hero.grade_calculator.value.Course;
import me.hero.grade_calculator.value.Courses;

public class GradeCalculator {

  private final Courses courses;

  public GradeCalculator(List<Course> courses) {
    this.courses = new Courses(courses);
  }

  public double calculateGrade() {
    double multipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
    int totalCompletedCredit = courses.calculateTotalCompletedCredit();
    return multipliedCreditAndCourseGrade / totalCompletedCredit;
  }
}
