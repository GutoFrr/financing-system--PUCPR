package financing;

public class House extends Financing {
  public House(double value, int deadline, double interestRate) {
    super(value, deadline, interestRate);
  }

  public double calculateMonthlyPayment() {
    return super.calculateMonthlyPayment() + 80;
  }
}
