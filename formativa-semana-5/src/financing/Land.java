package financing;

public class Land extends Financing {
  public Land(double value, int deadline, double interestRate) {
    super(value, deadline, interestRate);
  }

  public double calculateMonthlyPayment() {
    return super.calculateMonthlyPayment() * 1.02;
  }
}
