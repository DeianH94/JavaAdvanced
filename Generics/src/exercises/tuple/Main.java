package exercises.tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String name = firstLine.substring(0, firstLine.lastIndexOf(" "));
        String address = firstLine.substring(firstLine.lastIndexOf(" ") + 1);
        Tuple<String, String> nameAndAddress = new Tuple<>(name, address);
        System.out.println(nameAndAddress);

        String[] secondLine = scanner.nextLine().split("\\s+");
        String personName = secondLine[0];
        int amountOfBeer = Integer.parseInt(secondLine[1]);
        Tuple<String, Integer> nameAndBeerAmount = new Tuple<>(personName, amountOfBeer);
        System.out.println(nameAndBeerAmount);

        String[] lastLine = scanner.nextLine().split("\\s+");
        int firstNum = Integer.parseInt(lastLine[0]);
        double secondNum = Double.parseDouble(lastLine[1]);
        Tuple<Integer, Double> numbers = new Tuple<>(firstNum, secondNum);
        System.out.println(numbers);
    }
}
