package financing;

public abstract class Financing {
  private double propertyValue;
  private int financingDeadline;
  private double anualRate;

  public Financing(double value, int deadline, double interestRate) {
    this.propertyValue = value;
    this.financingDeadline = deadline;
    this.anualRate = interestRate;
  }

  // methods
  public double calculateMonthlyPayment() {
    return (this.propertyValue / (this.financingDeadline * 12)) * (1 + (this.anualRate / 12));
  }

  public double calculateTotalPayment() {
    return this.calculateMonthlyPayment() * this.financingDeadline * 12;
  }

  public void printFinancingData(int index) {
    System.out.println("Financiamento " + (index  + 1) + " - valor do imóvel: R$ " + Math.round(this.getPropertyValue())
        + ", valor do financiamento: R$ " + Math.round(this.calculateTotalPayment()));
  }

  // getters
  public double getPropertyValue() {
    return this.propertyValue;
  }

  public int getFinancingDeadline() {
    return this.financingDeadline;
  }

  public double getAnualRate() {
    return this.anualRate;
  }
}
