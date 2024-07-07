package financing;

import utils.CustomFileHandler;

public class Apartment extends Financing {
  private int garageSpace;
  private int floorNumber;

  public Apartment(double value, int deadline, double interestRate, int garageSpace, int floorNumber) {
    super(value, deadline, interestRate);

    this.garageSpace = garageSpace;
    this.floorNumber = floorNumber;
  }

  public double calculateMonthlyPayment() {
    double monthlyRate = this.getAnnualRate() / 12 / 100;
    int months = this.getFinancingDeadline() * 12;

    double numerator = this.getPropertyValue() * monthlyRate * Math.pow(1 + monthlyRate, months);
    double denominator = Math.pow(1 + monthlyRate, months) - 1;

    return numerator / denominator;
  }

  @Override
  public void writeFile() {
    CustomFileHandler customFileHandler = new CustomFileHandler();
    StringBuilder sb = super.fileDataSetup("Apartamento");

    sb.append("andar do apartamento: ").append(this.getFloorNumber());
    sb.append(", vaga da garagem: ").append(this.getGarageSpace() + " m²");

    String fileData = sb.append(". \n").toString();

    customFileHandler.writeTextFile("financiamentos.txt", fileData, true);
  }

  public int getFloorNumber() {
    return this.floorNumber;
  }

  public int getGarageSpace() {
    return this.garageSpace;
  }
}
