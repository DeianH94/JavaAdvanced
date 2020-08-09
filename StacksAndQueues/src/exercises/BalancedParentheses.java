package exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parentheses = scanner.nextLine();
        Deque<Character> stack = new ArrayDeque<>();

        String lookupTable = "({[";
        boolean areBalanced = true;

        for (int i = 0; i < parentheses.length(); i++) {
            char symbol = parentheses.charAt(i);

            if (lookupTable.contains(symbol + "")) {
                stack.push(symbol);
            } else {
                if (stack.isEmpty()) {
                    areBalanced = false;
                    break;
                }

                char top = stack.pop();
                if (!(top == '(' && symbol == ')'
                        || top == '{' && symbol == '}'
                        || top == '[' && symbol == ']')) {
                    areBalanced = false;
                    break;
                }
            }
        }

        System.out.println(areBalanced ? "YES" : "NO");
    }
}
