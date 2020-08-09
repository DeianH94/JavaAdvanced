package exercises;

import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> operatorStack = new ArrayDeque<>();
        Deque<String> outputQueue = new ArrayDeque<>();
        Map<String, Integer> priorities = new HashMap<>();
        priorities.put("*", 3);
        priorities.put("/", 3);
        priorities.put("+", 2);
        priorities.put("-", 2);
        priorities.put("(", 1);

        String[] inputTokens = scanner.nextLine().split("\\s+");
        for (String inputToken : inputTokens) {
            if (Character.isLetterOrDigit(inputToken.charAt(0))) {
                outputQueue.offer(inputToken);
            } else if (inputToken.equals("(")) {
                operatorStack.push(inputToken);
            } else if (inputToken.equals(")")) {
                while (!"(".equals(operatorStack.peek())) {
                    outputQueue.offer(operatorStack.pop());
                }

                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty()
                        && priorities.get(operatorStack.peek()) >= priorities.get(inputToken)) {
                    outputQueue.offer(operatorStack.pop());
                }

                operatorStack.push(inputToken);
            }
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.offer(operatorStack.pop());
        }

        System.out.println(String.join(" ", outputQueue));
    }
}
