package lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        if (decimalNumber == 0 || decimalNumber == 1) {
            System.out.println(decimalNumber);
        } else {
            while (decimalNumber != 0) {
                stack.push(decimalNumber % 2);
                decimalNumber /= 2;
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }

            System.out.println();
        }
    }
}
