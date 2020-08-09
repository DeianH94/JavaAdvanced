package exercises;

import java.util.*;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        Deque<Integer> numbersStack = new ArrayDeque<>();

        for (int number : numbers) {
            numbersStack.push(number);
        }

        while (!numbersStack.isEmpty()) {
            System.out.print(numbersStack.pop() + " ");
        }

        System.out.println();
    }
}
