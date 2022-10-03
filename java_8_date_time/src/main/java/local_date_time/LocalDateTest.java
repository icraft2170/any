package local_date_time;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class LocalDateTest {

  public static void main(String[] args) {
    //LocalDate 정적팩토리 메서드
    LocalDate date = LocalDate.of(2017, 2, 21);
    System.out.println(date.toString());

    // TemporalField 이용해 값 없기
    int year = date.get(ChronoField.YEAR);
    int month = date.get(ChronoField.MONTH_OF_YEAR);
    int day = date.get(ChronoField.DAY_OF_MONTH);
    int dayOfWeek = date.get(ChronoField.DAY_OF_WEEK);

    System.out.println("year = " + year);
    System.out.println("month = " + month);
    System.out.println("day = " + day);
    System.out.println("dayOfWeek = " + dayOfWeek);

    //

  }

}
