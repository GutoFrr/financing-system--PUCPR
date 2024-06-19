import java.util.ArrayList;
import java.util.List;

import userInterface.UserInterface;
import financing.Financing;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        List<Financing> financingList = new ArrayList<Financing>();

        while (financingList.size() < 4) {
            int financingSize = financingList.size() + 1;

            System.out.println();
            System.out.println("===== Financiamento " + financingSize + " =====");
            double propertyValue = userInterface.getPropertyValue();
            int financingDeadline = userInterface.getFinancingDeadline();
            double interestRate = userInterface.getInterestRate();

            financingList.add(new Financing(propertyValue, financingDeadline, interestRate));
        }

        for (Financing item : financingList) {
            int index = financingList.indexOf(item);
            item.printFinancingData(index);
        }

        double totalPropertyValue = calculateTotalPropertyValue(financingList);
        double totalFinancing = calculateTotalFinancing(financingList);

        System.out.println("Total de todos os imóveis: R$ " + totalPropertyValue
                + ", total de todos os financiamentos: R$ " + totalFinancing);
    }

    private static double calculateTotalPropertyValue(List<Financing> list) {
        double total = 0;
        for (Financing item : list) {
            total += item.getPropertyValue();
        }
        return total;
    }

    private static double calculateTotalFinancing(List<Financing> list) {
        double total = 0;
        for (Financing item : list) {
            total += item.calculateTotalPayment();
        }
        return total;
    }
}