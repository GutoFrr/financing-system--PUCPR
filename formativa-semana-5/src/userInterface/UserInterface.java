package userInterface;

import java.util.Scanner;

public class UserInterface {
  private static Scanner scanner = new Scanner(System.in);

  public double getPropertyValue() {
    System.out.println("Informe o valor do imóvel: ");
    double value = scanner.nextDouble();

    while (value < 0) {
      System.out.println();
      System.out.println("O valor do imóvel deve ser maior que zero.");
      System.out.println("Informe um valor válido para o imóvel: ");

      value = scanner.nextDouble();
    }

    System.out.println();
    return value;
  }

  public int getFinancingDeadline() {
    System.out.println("Informe o prazo do financiamento em anos: ");
    int deadline = scanner.nextInt();

    while (deadline < 0) {
      System.out.println();
      System.out.println("O prazo do financiamento deve ser maior que zero.");
      System.out.println("Informe um prazo válido para o financiamento: ");

      deadline = scanner.nextInt();
    }

    System.out.println();
    return deadline;
  }

  public double getInterestRate() {
    System.out.println("Informe a taxa de juros anual: ");
    double rate = scanner.nextDouble();

    while (rate < 0) {
      System.out.println();
      System.out.println("A taxa de juros deve ser maior que zero.");
      System.out.println("Informe um valor válido para a taxa de juros: ");

      rate = 0;
    }

    System.out.println();
    return rate;
  }
}
