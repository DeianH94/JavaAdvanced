package exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCommands = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numOfCommands; i++) {
            String command = scanner.nextLine();
            if (command.startsWith("1")) {
                int numToPush = Integer.parseInt(command.split("\\s+")[1]);
                stack.push(numToPush);
            } else if (command.equals("2")) {
                stack.pop();
            } else if (command.equals("3")) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
