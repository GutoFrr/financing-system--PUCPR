import java.util.ArrayList;
import java.util.List;

import financing.Apartment;
import financing.Financing;
import financing.House;
import financing.Land;
import utils.CustomFileHandler;
import utils.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        List<Financing> financingList = new ArrayList<Financing>();
        CustomFileHandler customFileHandler = new CustomFileHandler();

        System.out.println();
        System.out.println("===== Financiamento - Casa =====");

        double propertyValue = userInterface.getPropertyValue();
        int financingDeadline = userInterface.getFinancingDeadline();
        double interestRate = userInterface.getInterestRate();
        double builtArea = userInterface.getBuiltArea();
        double landArea = userInterface.getLandArea();
        double monthlyIncrease = userInterface.getMonthlyIncrease();

        House house = new House(propertyValue, financingDeadline, interestRate, builtArea, landArea, monthlyIncrease);

        financingList.add(house);
        financingList.add(new House(500000, 10, 10, 89, 230, 40));
        financingList.add(new Apartment(500000, 10, 10, 26, 10));
        financingList.add(new Apartment(530000, 15, 12, 30, 12));
        financingList.add(new Land(1000000, 20, 6, "Urbana"));

        for (Financing item : financingList) {
            item.writeFile();
        }

        double totalPropertyValue = calculateTotalPropertyValue(financingList);
        double totalFinancing = calculateTotalFinancing(financingList);

        customFileHandler.readTextFile("financiamentos.txt");

        System.out.println();
        System.out.println("Total de todos os imóveis: R$ " + totalPropertyValue
                + ", total de todos os financiamentos: R$ " + totalFinancing);

        customFileHandler.serializeObject(financingList);
        customFileHandler.deserializeObject();
    }

    private static double calculateTotalPropertyValue(List<Financing> list) {
        double total = 0;
        for (Financing item : list) {
            total += item.getPropertyValue();
        }
        return Math.round(total);
    }

    private static double calculateTotalFinancing(List<Financing> list) {
        double total = 0;
        for (Financing item : list) {
            total += item.calculateTotalPayment();
        }
        return Math.round(total);
    }
}