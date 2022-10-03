import java.time.Duration;
import java.time.LocalDateTime;

public class DurationTest {

  public static void main(String[] args) {
    LocalDateTime datetime = LocalDateTime.of(2017, 02, 03, 0,0,0);
    Duration between = Duration.between(datetime, LocalDateTime.now());
    System.out.println("between = " + between.getNano());
    System.out.println("between.getSeconds() = " + between.getSeconds());
  }

}
