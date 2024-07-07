package financing;

import java.io.*;

import utils.CustomFileHandler;

public abstract class Financing implements Serializable {
  private double propertyValue;
  private int financingDeadline;
  private double annualRate;

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
    CustomFileHandler customFileHandler = new CustomFileHandler();
    customFileHandler.readTextFile("financiamentos.txt");
  }

  public StringBuilder fileDataSetup(String type) {
    CustomFileHandler customFileHandler = new CustomFileHandler();
    StringBuilder sb = new StringBuilder();

    int count = customFileHandler.getTextFileLinesCount("financiamentos.txt");

    sb.append("Financiamento ")
      .append(count + 1 + " - ").append(type + " - ")
      .append("valor do imóvel: ").append("R$ " + Math.round(this.getPropertyValue()))
      .append(", valor do financiamento: ")
      .append("R$ " + Math.round(this.calculateTotalPayment()))
      .append(", taxa de juros: ").append(this.getAnnualRate() + "%")
      .append(", prazo do financiamento: ").append(this.getFinancingDeadline() + " anos");

    return sb;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("Financiamento {")
      .append("\n  valor da propriedade: ").append("R$ " + Math.round(this.getPropertyValue()))
      .append(",\n  prazo do financiamento: ").append(this.getFinancingDeadline() + " anos")
      .append(",\n  taxa de juros: ").append(this.getAnnualRate() + "%")
      .append("\n}");

    return sb.toString();
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
