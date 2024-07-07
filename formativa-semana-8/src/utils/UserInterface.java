package utils;

import java.util.Scanner;
import java.util.function.Predicate;

public class UserInterface {
  private static Scanner scanner = new Scanner(System.in);

  private <T> T getValidatedInput(String msg, String error, Class<T> type, Predicate<T> validator)
      throws InvalidInputException {
    while (true) {
      try {
        System.out.println(msg);

        if (type == Integer.class && scanner.hasNextInt()) {
          T value = type.cast(scanner.nextInt());
          if (validator.test(value)) {
            System.out.println();
            return value;
          } else {
            throw new InvalidInputException(error);
          }
        } else if (type == Double.class && scanner.hasNextDouble()) {
          T value = type.cast(scanner.nextDouble());
          if (validator.test(value)) {
            System.out.println();
            return value;
          } else {
            throw new InvalidInputException(error);
          }
        } else {
          System.out.println();
          System.out.println("Entrada inválida. Por favor, insira um número.");
          scanner.next();
        }
      } catch (InvalidInputException e) {
        System.out.println();
        System.out.println(e.getMessage());
      } catch (Exception e) {
        System.out.println();
        System.out.println("Entrada inválida. Por favor, insira um número.");
        scanner.next();
      }
      System.out.println();
    }
  }

  public double getPropertyValue() {
    try {
      String msg = "Informe o valor do imóvel: ";
      String error = "Valor do imóvel deve ser maior que 0. Tente novamente.";

      return this.getValidatedInput(msg, error, Double.class, value -> value > 0);
    } catch (InvalidInputException e) {
      return 0;
    }
  }

  public int getFinancingDeadline() {
    try {
      String msg = "Informe o prazo do financiamento em anos: ";
      String error = "O prazo do financiamento deve ser maior que 0. Tente novamente.";

      return this.getValidatedInput(msg, error, Integer.class, value -> value > 0);
    } catch (InvalidInputException e) {
      return 0;
    }
  }

  public double getInterestRate() {
    try {
      String msg = "Informe a taxa de juros anual: ";
      String error = "A taxa de juros deve ser maior que 0. Tente novamente.";

      return this.getValidatedInput(msg, error, Double.class, value -> value > 0);
    } catch (InvalidInputException e) {
      return 0;
    }
  }

  public double getBuiltArea() {
    try {
      String msg = "Informe a área construída: ";
      String error = "A área construída deve ser maior que 0. Tente novamente.";

      return this.getValidatedInput(msg, error, Double.class, value -> value > 0);
    } catch (InvalidInputException e) {
      return 0;
    }
  }

  public double getLandArea() {
    try {
      String msg = "Informe a área do terreno: ";
      String error = "A área do terreno deve ser maior que 0. Tente novamente.";

      return this.getValidatedInput(msg, error, Double.class, value -> value > 0);
    } catch (InvalidInputException e) {
      return 0;
    }
  }

  public double getMonthlyIncrease() {
    try {
      String msg = "Informe o acréscimo na mensalidade da casa: ";
      String error = "O acréscimo deve ser maior que 0. Tente novamente.";

      return this.getValidatedInput(msg, error, Double.class, value -> value > 0);
    } catch (InvalidInputException e) {
      return 0;
    }
  }
}
