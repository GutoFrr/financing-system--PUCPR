package financing;

public class House extends Financing {
  private double builtArea;
  private double landArea;

  public House(double value, int deadline, double interestRate, double builtArea, double landArea) {
    super(value, deadline, interestRate);

    this.builtArea = builtArea;
    this.landArea = landArea;
  }

  public double calculateMonthlyPayment() {
    return super.calculateMonthlyPayment() + 80;
  }
}
