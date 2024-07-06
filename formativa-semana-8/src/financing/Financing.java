package financing;

import utils.CustomFileHandler;

public abstract class Financing {
  private double propertyValue;
  private int financingDeadline;
  private double annualRate;
  private CustomFileHandler customFileHandler = new CustomFileHandler();

  public Financing(double value, int deadline, double interestRate) {
    this.propertyValue = value;
    this.financingDeadline = deadline;
    this.annualRate = interestRate;
  }

  public double calculateMonthlyPayment() {
    return (this.propertyValue / (this.financingDeadline * 12)) * (1 + (this.annualRate / 12));
  }

  public double calculateTotalPayment() {
    return this.calculateMonthlyPayment() * this.financingDeadline * 12;
  }

  public void printFinancingData() {
    this.customFileHandler.readTextFile("financiamentos.txt");
  }

  public StringBuilder fileDataSetup(String type) {
    StringBuilder sb = new StringBuilder();

    int count = customFileHandler.getTextFileLinesCount("financiamentos.txt");
    if (count == 0) {
      count = 1;
    }
    
    sb.append("Financiamento ").append(count + " - ").append(type + " - ");
    sb.append("valor do imóvel: ").append("R$ " + this.getPropertyValue()).append(", ");
    sb.append("valor do financiamento: ").append("R$ " + Math.round(this.calculateTotalPayment())).append(", ");
    sb.append("taxa de juros: ").append(this.getAnnualRate() + "%").append(", ");
    sb.append("prazo do financiamento: ").append(this.getFinancingDeadline() + " anos").append(", ");

    return sb;
  }

  public abstract void writeFile();

  public double getPropertyValue() {
    return this.propertyValue;
  }

  public int getFinancingDeadline() {
    return this.financingDeadline;
  }

  public double getAnnualRate() {
    return this.annualRate;
  }
}
