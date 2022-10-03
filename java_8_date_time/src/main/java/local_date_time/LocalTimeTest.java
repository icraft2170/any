package local_date_time;

import java.time.LocalTime;

public class LocalTimeTest {

  public static void main(String[] args) {
    LocalTime time = LocalTime.of(20, 43, 30);
    System.out.println("time : " + time);

    int hour = time.getHour();
    int minute = time.getMinute();
    int second = time.getSecond();
    System.out.println("Time : " + hour + ":" + minute + ":" + second);
  }

}
