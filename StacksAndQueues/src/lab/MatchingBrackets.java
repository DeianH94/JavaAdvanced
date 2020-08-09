package lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        String equation = scanner.nextLine();

        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '(') {
                stack.push(i);
            } else if (equation.charAt(i) == ')') {
                int startIndex = stack.pop();
                String contents = equation.substring(startIndex, i + 1);
                System.out.println(contents);
            }
        }
    }
}
