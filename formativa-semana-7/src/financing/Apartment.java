package financing;

public class Apartment extends Financing {
  private int garageSpaces;
  private int floorNumber;

  public Apartment(double value, int deadline, double interestRate, int garageSpaces, int floorNumber) {
    super(value, deadline, interestRate);

    this.garageSpaces = garageSpaces;
    this.floorNumber = floorNumber;
  }

  public double calculateMonthlyPayment() {
    double monthlyRate = this.getAnnualRate() / 12 / 100;
    int months = this.getFinancingDeadline() * 12;

    double numerator = this.getPropertyValue() * monthlyRate * Math.pow(1 + monthlyRate, months);
    double denominator = Math.pow(1 + monthlyRate, months) - 1;

    return numerator / denominator;
  }
}
