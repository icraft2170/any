package game.book.chapter03;

import java.time.LocalDate;

public class PayDate {
  private LocalDate firstBillingDate;
  private LocalDate billingDate;
  private int payAmount;

  public PayDate() {
  }

  public PayDate(LocalDate firstBillingDate, LocalDate billingDate, int payAmount) {
    this.firstBillingDate = firstBillingDate;
    this.billingDate = billingDate;
    this.payAmount = payAmount;
  }

  public LocalDate getBillingDate() {
    return billingDate;
  }

  public int getPayAmount() {
    return payAmount;
  }

  public LocalDate getFirstBillingDate() {
    return firstBillingDate;
  }

  public static Builder builder() {
    return new Builder();
  }
  public static class Builder {
    private final PayDate data = new PayDate();

    public Builder billingDate(LocalDate billingDate) {
      data.billingDate = billingDate;
      return this;
    }

    public Builder payAmount(int payAmount) {
      data.payAmount = payAmount;
      return this;
    }

    public Builder firstBillingDate(LocalDate firstBillingDate) {
      data.firstBillingDate = firstBillingDate;
      return this;
    }

    public PayDate build() {
      return data;
    }
  }
}
