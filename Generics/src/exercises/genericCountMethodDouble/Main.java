package exercises.genericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numOfLines = Double.parseDouble(scanner.nextLine());
        Box<Double> box = new Box<>();

        for (int i = 0; i < numOfLines; i++) {
            box.add(Double.parseDouble(scanner.nextLine()));
        }

        double numToCompare = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countOfGraterElements(numToCompare));
    }
}
