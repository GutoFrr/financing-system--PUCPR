package financing;

import utils.CustomFileHandler;

public class House extends Financing {
  private double builtArea;
  private double landArea;
  private double monthlyIncrease;

  public House(double value, int deadline, double interestRate, double builtArea, double landArea,
      double monthlyIncrease) {
    super(value, deadline, interestRate);

    this.builtArea = builtArea;
    this.landArea = landArea;
    this.monthlyIncrease = monthlyIncrease;
  }

  private void validateIncrease() throws IncreaseGreaterThenRateException {
    if (this.getMonthlyIncrease() > this.getAnnualRate()) {
      throw new IncreaseGreaterThenRateException("Valor do acréscimo não pode ser maior que a taxa de juros.");
    }
  }

  public double calculateMonthlyPayment() {
    try {
      this.validateIncrease();
    } catch (Exception e) {
      this.monthlyIncrease = this.getAnnualRate();

      System.out.println();
      System.out.println(e.getMessage());
    }

    return super.calculateMonthlyPayment() + this.getMonthlyIncrease();
  }

  @Override
  public void writeFile() {
    CustomFileHandler customFileHandler = new CustomFileHandler();
    StringBuilder sb = super.fileDataSetup("Casa");

    sb.append("área construída: ").append(this.getBuiltArea() + " m²")
      .append(", área do terreno: ").append(this.getLandArea() + " m²")
      .append(", acréscimo mensal: ").append(this.getMonthlyIncrease() + "%");

    String fileData = sb.append(". \n").toString();

    customFileHandler.writeTextFile("financiamentos.txt", fileData, true);
  }

  public double getBuiltArea() {
    return this.builtArea;
  }

  public double getLandArea() {
    return this.landArea;
  }

  public double getMonthlyIncrease() {
    return this.monthlyIncrease;
  }
}

class IncreaseGreaterThenRateException extends Exception {
  public IncreaseGreaterThenRateException(String msg) {
    super(msg);
  }
}