package exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        int[] setSizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < setSizes[0]; i++) {
            int numberToAdd = Integer.parseInt(scanner.nextLine());
            firstSet.add(numberToAdd);
        }

        for (int i = 0; i < setSizes[1]; i++) {
            int numberToAdd = Integer.parseInt(scanner.nextLine());
            secondSet.add(numberToAdd);
        }

        for (Integer number : firstSet) {
            if (secondSet.contains(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
