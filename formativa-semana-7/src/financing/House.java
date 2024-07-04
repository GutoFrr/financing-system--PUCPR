package financing;

public class House extends Financing {
  private double builtArea;
  private double landArea;

  public House(double value, int deadline, double interestRate, double builtArea, double landArea) {
    super(value, deadline, interestRate);

    this.builtArea = builtArea;
    this.landArea = landArea;
  }

  private void validateIncrease(double rate, double increase) throws IncreaseGreaterThenRateException {
    if (increase > rate) {
      throw new IncreaseGreaterThenRateException("Valor do acréscimo não pode ser maior que a taxa de juros.");
    }
  }

  public double calculateMonthlyPayment() {
    double rate = 40;
    double increase = 80;

    try {
      this.validateIncrease(rate, increase);
    } catch (Exception e) {
      increase = rate;
      System.out.println(e.getMessage());
    }

    return super.calculateMonthlyPayment() + increase;
  }
}

class IncreaseGreaterThenRateException extends Exception {
  public IncreaseGreaterThenRateException(String msg) {
    super(msg);
  }
}