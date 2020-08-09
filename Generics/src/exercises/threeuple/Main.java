package exercises.threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        String name = firstLine[0] + " " + firstLine[1];
        String address = firstLine[2];
        String town = firstLine[3];
        Threeuple<String, String, String> nameAndAddress = new Threeuple<>(name, address, town);
        System.out.println(nameAndAddress);

        String[] secondLine = scanner.nextLine().split("\\s+");
        String personName = secondLine[0];
        int amountOfBeer = Integer.parseInt(secondLine[1]);
        String condition = secondLine[2];
        boolean isDrunk = false;
        if (condition.equalsIgnoreCase("drunk")) {
            isDrunk = true;
        }

        Threeuple<String, Integer, Boolean> nameAndBeerAmount = new Threeuple<>(personName, amountOfBeer, isDrunk);
        System.out.println(nameAndBeerAmount);

        String[] lastLine = scanner.nextLine().split("\\s+");
        String clientName = lastLine[0];
        double accountBalance = Double.parseDouble(lastLine[1]);
        String bankName = lastLine[2];
        Threeuple<String, Double, String> numbers = new Threeuple<>(clientName, accountBalance, bankName);
        System.out.println(numbers);
    }
}
