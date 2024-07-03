package financing;

public class Land extends Financing {
  private String zone;

  public Land(double value, int deadline, double interestRate, String zone) {
    super(value, deadline, interestRate);

    this.zone = zone;
  }

  public double calculateMonthlyPayment() {
    return super.calculateMonthlyPayment() * 1.02;
  }
}
