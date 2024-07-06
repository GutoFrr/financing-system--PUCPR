package financing;

import utils.CustomFileHandler;

public class House extends Financing {
  private double builtArea;
  private double landArea;
  private CustomFileHandler customFileHandler = new CustomFileHandler();

  public House(double value, int deadline, double interestRate, double builtArea, double landArea) {
    super(value, deadline, interestRate);

    this.builtArea = builtArea;
    this.landArea = landArea;
  }

  private void validateIncrease(double increase) throws IncreaseGreaterThenRateException {
    if (increase > this.getAnnualRate()) {
      throw new IncreaseGreaterThenRateException("Valor do acréscimo não pode ser maior que a taxa de juros.");
    }
  }

  public double calculateMonthlyPayment() {
    double increase = 80;

    try {
      this.validateIncrease(increase);
    } catch (Exception e) {
      increase = this.getAnnualRate();
      System.out.println(e.getMessage());
    }

    return super.calculateMonthlyPayment() + increase;
  }

  @Override
  public void writeFile() {
    StringBuilder sb = super.fileDataSetup("Casa");

    sb.append("área construída: ").append(this.builtArea + " m²").append(", ");
    sb.append("área do terreno: ").append(this.landArea + " m²");

    String fileData = sb.append(". \n").toString();

    customFileHandler.writeTextFile("financiamentos.txt", fileData, true);
  }
}

class IncreaseGreaterThenRateException extends Exception {
  public IncreaseGreaterThenRateException(String msg) {
    super(msg);
  }
}