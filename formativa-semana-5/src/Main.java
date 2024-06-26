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
        int houseQuantity = 0;
        int apartmentQuantity = 0;
        int landQuantity = 0;

        while (financingList.size() < 5) {
            if (financingList.size() < 2) {
                houseQuantity += 1;

                System.out.println();
                System.out.println("===== Financiamento - Casa " + houseQuantity + " =====");

                double propertyValue = userInterface.getPropertyValue();
                int financingDeadline = userInterface.getFinancingDeadline();
                double interestRate = userInterface.getInterestRate();

                financingList.add(new House(propertyValue, financingDeadline, interestRate));
            } else if (financingList.size() < 4) {
                apartmentQuantity += 1;

                System.out.println();
                System.out.println("===== Financiamento - Apartamento " + apartmentQuantity + " =====");

                double propertyValue = userInterface.getPropertyValue();
                int financingDeadline = userInterface.getFinancingDeadline();
                double interestRate = userInterface.getInterestRate();

                financingList.add(new Apartment(propertyValue, financingDeadline, interestRate));
            } else {
                landQuantity += 1;

                System.out.println();
                System.out.println("===== Financiamento - Terreno " + landQuantity + " =====");

                double propertyValue = userInterface.getPropertyValue();
                int financingDeadline = userInterface.getFinancingDeadline();
                double interestRate = userInterface.getInterestRate();

                financingList.add(new Land(propertyValue, financingDeadline, interestRate));
            }
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