import java.util.ArrayList;
import java.util.List;

import userInterface.UserInterface;
import financing.Apartment;
import financing.Financing;
import financing.House;
import financing.Land;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        List<Financing> financingList = new ArrayList<Financing>();

        System.out.println();
        System.out.println("===== Financiamento - Casa =====");

        double propertyValue = userInterface.getPropertyValue();
        int financingDeadline = userInterface.getFinancingDeadline();
        double interestRate = userInterface.getInterestRate();
        double builtArea = userInterface.getBuiltArea();
        double landArea = userInterface.getLandArea();

        financingList.add(new House(propertyValue, financingDeadline, interestRate, builtArea, landArea));
        financingList.add(new House(500000, 10, 10, 89, 230));
        financingList.add(new Apartment(500000, 10, 10, 26, 10));
        financingList.add(new Apartment(500000, 15, 12, 30, 12));
        financingList.add(new Land(1000000, 20, 6, "Rural"));

        for (Financing item : financingList) {
            int index = financingList.indexOf(item);
            item.printFinancingData(index);
        }

        double totalPropertyValue = calculateTotalPropertyValue(financingList);
        double totalFinancing = calculateTotalFinancing(financingList);

        System.out.println("Total de todos os imóveis: R$ " + Math.round(totalPropertyValue)
                + ", total de todos os financiamentos: R$ " + Math.round(totalFinancing));
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