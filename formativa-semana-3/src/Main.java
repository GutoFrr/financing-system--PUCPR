import userInterface.UserInterface;
import financing.Financing;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        double propertyValue = userInterface.getPropertyValue();
        int financingDeadline = userInterface.getFinancingDeadline();
        double interestRate = userInterface.getInterestRate();

        Financing financing = new Financing(propertyValue, financingDeadline, interestRate);

        financing.printFinancingData();
    }
}