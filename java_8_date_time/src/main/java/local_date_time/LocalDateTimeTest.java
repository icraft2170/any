package local_date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest {

  public static void main(String[] args) {
    LocalDateTime dateTime = LocalDateTime.of(2017, Month.JANUARY, 21, 10, 22, 30);
    System.out.println(dateTime);

    LocalDate localDate = dateTime.toLocalDate();
    System.out.println("localDate = " + localDate);

    LocalTime localTime = dateTime.toLocalTime();
    System.out.println("localTime = " + localTime);
  }
}
