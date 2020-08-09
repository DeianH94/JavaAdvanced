package exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> uniqueElements = new TreeSet<>();
        int numOfChemicalCompounds = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfChemicalCompounds; i++) {
            String[] compoundElements = scanner.nextLine().split("\\s+");
            uniqueElements.addAll(Arrays.asList(compoundElements));
        }

        uniqueElements.forEach(e -> System.out.print(e + " "));
    }
}
