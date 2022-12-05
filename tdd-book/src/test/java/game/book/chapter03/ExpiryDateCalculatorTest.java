package game.book.chapter03;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class ExpiryDateCalculatorTest {

  @Test
  void 만원_납부하면_한달_뒤가_만료일이_됨() {
    assertExpiryDate(LocalDate.of(2019, 4, 1), PayDate.builder()
        .billingDate(LocalDate.of(2019, 3, 1))
        .payAmount(10_000)
        .build());
    assertExpiryDate(LocalDate.of(2019,6, 5), PayDate.builder()
        .billingDate(LocalDate.of(2019, 5, 5))
        .payAmount(10_000)
        .build());
  }


  @Test
  void 납부일과_한달_뒤_일자가_같지_않음() {
    assertExpiryDate(
        LocalDate.of(2019,2,28), PayDate.builder()
            .billingDate(LocalDate.of(2019,1,31))
            .payAmount(10_000)
            .build());
    assertExpiryDate(
        LocalDate.of(2019,6,30), PayDate.builder()
            .billingDate(LocalDate.of(2019,5,31))
            .payAmount(10_000)
            .build());
    assertExpiryDate(
        LocalDate.of(2020,2,29), PayDate.builder()
            .billingDate(LocalDate.of(2020,1,31))
            .payAmount(10_000)
            .build());
  }

  @Test
  void 첫_납부일과_만료일_일자가_다를때_만원_납부() {
    PayDate payData = PayDate.builder()
        .firstBillingDate(LocalDate.of(2019, 1, 31))
        .billingDate(LocalDate.of(2019, 2, 28))
        .payAmount(10_000)
        .build();
    assertExpiryDate(LocalDate.of(2019, 3, 31), payData);

    PayDate payData2 = PayDate.builder()
        .firstBillingDate(LocalDate.of(2019, 1, 30))
        .billingDate(LocalDate.of(2019, 2, 28))
        .payAmount(10_000)
        .build();
    assertExpiryDate(LocalDate.of(2019, 3, 30), payData2);

    PayDate payData3 = PayDate.builder()
        .firstBillingDate(LocalDate.of(2019, 5, 31))
        .billingDate(LocalDate.of(2019, 6, 30))
        .payAmount(10_000)
        .build();
    assertExpiryDate(LocalDate.of(2019, 7, 31), payData3);
  }

  @Test
  void 이만원_이상_납부하면_비례해서_만료일_계산() {
    assertExpiryDate(
        LocalDate.of(2019, 5, 1),
        PayDate.builder()
            .billingDate(LocalDate.of(2019, 3, 1))
            .payAmount(20_000)
            .build()
    );

    assertExpiryDate(
        LocalDate.of(2019, 6, 1),
        PayDate.builder()
            .billingDate(LocalDate.of(2019, 3, 1))
            .payAmount(30_000)
            .build()
    );
  }

  @Test
  void 첫_납부일과_만료일_일자가_다를때_이만원_이상_납부() {
    assertExpiryDate(
        LocalDate.of(2019, 4, 30),
        PayDate.builder()
            .firstBillingDate(LocalDate.of(2019, 1, 31))
            .billingDate(LocalDate.of(2019, 2, 28))
            .payAmount(20_000)
            .build()
    );
    assertExpiryDate(
        LocalDate.of(2019, 7, 31),
        PayDate.builder()
            .firstBillingDate(LocalDate.of(2019, 3, 31))
            .billingDate(LocalDate.of(2019, 4, 30))
            .payAmount(30_000)
            .build()
    );
    assertExpiryDate(
        LocalDate.of(2019, 6, 30),
        PayDate.builder()
            .firstBillingDate(LocalDate.of(2019, 1, 31))
            .billingDate(LocalDate.of(2019, 2, 28))
            .payAmount(40_000)
            .build()
    );
  }

  @Test
  void 십만원을_납부하면_1년_제공() {
    assertExpiryDate(
        LocalDate.of(2020, 1, 28),
        PayDate.builder()
            .billingDate(LocalDate.of(2019, 1, 28))
            .payAmount(100_000)
            .build()
    );
  }

  private static void assertExpiryDate(
      LocalDate expectedExpiryDate, PayDate pd) {
    ExpiryDateCalculator cal = new ExpiryDateCalculator();
    LocalDate expiryDate = cal.calculateExpiryDate(pd);
    assertEquals(expectedExpiryDate, expiryDate);
  }

}