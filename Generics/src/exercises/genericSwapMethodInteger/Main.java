package exercises.genericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());
        List<Box<Integer>> boxList = new ArrayList<>();

        for (int i = 0; i < numOfLines; i++) {
            Box<Integer> box = new Box<>(Integer.parseInt(scanner.nextLine()));
            boxList.add(box);
        }

        int[] swapIndexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        GenericSwap.swap(boxList, swapIndexes[0], swapIndexes[1]);

        boxList.forEach(System.out::println);
    }
}
