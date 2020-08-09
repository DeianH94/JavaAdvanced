package exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numOfOperations = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numOfPushes = numOfOperations[0];
        int numOfPops = numOfOperations[1];
        int numToFind = numOfOperations[2];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numOfPushes; i++) {
            stack.push(sequence[i]);
        }

        for (int i = 0; i < numOfPops; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            if (stack.contains(numToFind)) {
                System.out.println("true");
            } else {
                int min = Integer.MAX_VALUE;
                while (!stack.isEmpty()) {
                    min = Math.min(min, stack.pop());
                }

                System.out.println(min);
            }
        }
    }
}
