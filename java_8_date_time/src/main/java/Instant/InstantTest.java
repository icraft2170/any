package Instant;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;

public class InstantTest {

  public static void main(String[] args) {
    LocalDateTime dateTime = LocalDateTime.of(2020, 01, 01, 00, 00, 00);
    Instant instant = dateTime.toInstant(ZoneOffset.UTC);
    System.out.println(instant.getEpochSecond());

    Instant nanoSec = Instant.ofEpochSecond(3, 1_000_000_000);
    System.out.println(nanoSec.getNano());
  }

}
