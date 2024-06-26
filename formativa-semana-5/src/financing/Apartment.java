package financing;

public class Apartment extends Financing {
  public Apartment(double value, int deadline, double interestRate) {
    super(value, deadline, interestRate);
  }

  public double calculateMonthlyPayment() {
    double monthlyRate = this.getAnualRate() / 12 / 100;
    int months = this.getFinancingDeadline() * 12;

    double numerator = this.getPropertyValue() * monthlyRate * Math.pow(1 + monthlyRate, months);
    double denominator = Math.pow(1 + monthlyRate, months) - 1;

    return numerator / denominator;
  }
}
