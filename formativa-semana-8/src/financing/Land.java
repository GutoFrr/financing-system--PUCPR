package financing;

import utils.CustomFileHandler;

public class Land extends Financing {
  private String zone;
  private CustomFileHandler customFileHandler = new CustomFileHandler();

  public Land(double value, int deadline, double interestRate, String zone) {
    super(value, deadline, interestRate);

    this.zone = zone;
  }

  public double calculateMonthlyPayment() {
    return super.calculateMonthlyPayment() * 1.02;
  }

  @Override
  public void writeFile() {
    StringBuilder sb = super.fileDataSetup("Terreno");

    sb.append("zona: ").append(this.zone);

    String fileData = sb.append(". \n").toString();

    customFileHandler.writeTextFile("financiamentos.txt", fileData, true);
  }
}
