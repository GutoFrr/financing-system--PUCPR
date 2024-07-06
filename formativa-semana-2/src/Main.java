import java.util.Scanner;

class Financing {
    double propertyValue;
    int financingDeadline;
    double annualRate;

    Financing(double value, int deadline, double interestRate) {
        this.propertyValue = value;
        this.financingDeadline = deadline;
        this.annualRate = interestRate;
    }

    double calculateMonthlyPayment() {
        return (this.propertyValue / (this.financingDeadline * 12)) * (1 + (this.annualRate / 12));
    }

    double calculateTotalPayment() {
        return this.calculateMonthlyPayment() * this.financingDeadline * 12;
    }
}

class UserInterface {
    Scanner scanner = new Scanner(System.in);

    double getPropertyValue() {
        System.out.println("Informe o valor do imóvel: ");
        return this.scanner.nextDouble();
    }

    int getFinancingDeadline() {
        System.out.println("Informe o prazo do financiamento em anos: ");
        return this.scanner.nextInt();
    }

    double getInterestRate() {
        System.out.println("Informe a taxa de juros anual: ");
        return this.scanner.nextDouble();
    }
}

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        double propertyValue = userInterface.getPropertyValue();
        int financingDeadline = userInterface.getFinancingDeadline();
        double interestRate = userInterface.getInterestRate();

        Financing financing = new Financing(propertyValue, financingDeadline, interestRate);

        double totalPayment = financing.calculateTotalPayment();
        System.out.println("O valor do financiamento é de: " + totalPayment);
    }
}