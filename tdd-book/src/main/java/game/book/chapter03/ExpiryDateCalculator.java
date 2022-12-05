package game.book.chapter03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

  public LocalDate calculateExpiryDate(PayDate payDate) {
    int addedMonths = payDate.getPayAmount() == 100_000 ? 12 : payDate.getPayAmount() / 10_000;
    if (payDate.getFirstBillingDate() != null) {
      return expiryDateUsingFirstBillingDate(payDate, addedMonths);
    } else {
      return payDate.getBillingDate().plusMonths(addedMonths);
    }
  }

  private static LocalDate expiryDateUsingFirstBillingDate(PayDate payDate, int addedMonths) {
    LocalDate candidateExp = payDate.getBillingDate().plusMonths(addedMonths);
    if (isSameDayOfMonth(payDate, candidateExp)) {
      final int dayOfFirstBilling = payDate.getFirstBillingDate().getDayOfMonth();
      final int dayLenOfCadiMon = lastDayOfMonth(candidateExp);
      if (dayLenOfCadiMon < dayOfFirstBilling) {
        return candidateExp.withDayOfMonth(dayLenOfCadiMon);
      }
      return candidateExp.withDayOfMonth(dayOfFirstBilling);
    } else {
      return candidateExp;
    }
  }

  private static boolean isSameDayOfMonth(PayDate payDate, LocalDate candidateExp) {
    return payDate.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth();
  }

  private static int lastDayOfMonth(LocalDate candidateExp) {
    return YearMonth.from(candidateExp).lengthOfMonth();
  }

}
