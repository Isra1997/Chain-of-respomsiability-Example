import java.util.UUID;

public class Invoice {
  private final double amount;
  private double tax;
  private final boolean dineIn;
  private double totalAmount;
  private final UUID uuid;


  public Invoice(double amount, UUID uuid,boolean dineIn) {
    this.amount = amount;
    this.uuid = uuid;
    this.dineIn = dineIn;
  }

  public double getTax() {
    return tax;
  }

  public void setTax(double tax) {
    this.tax = tax;
  }

  public double getAmount() {
    return amount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public boolean isDineIn() {
    return dineIn;
  }


}
