package exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> deletedCharacters = new ArrayDeque<>();
        Deque<Integer> numOfAddedCharacters = new ArrayDeque<>();
        Deque<Character> commandsStack = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        int numOfOperations = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfOperations; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            int commandType = Integer.parseInt(command[0]);
            if (commandType == 1) {
                String stringToAdd = command[1];
                numOfAddedCharacters.push(stringToAdd.length());
                text.append(stringToAdd);
                commandsStack.push('a');
            } else if (commandType == 2) {
                int numOfCharsToRemove = Integer.parseInt(command[1]);
                deletedCharacters.push(text.substring(text.length() - numOfCharsToRemove, text.length()));
                text.delete(text.length() - numOfCharsToRemove, text.length());
                commandsStack.push('d');
            } else if (commandType == 3) {
                int indexToDisplay = Integer.parseInt(command[1]);
                System.out.println(text.charAt(indexToDisplay - 1));
            } else if (commandType == 4) {
                if (commandsStack.pop() == 'd') {
                    text.append(deletedCharacters.poll());
                } else {
                    text.delete(text.length() - numOfAddedCharacters.pop(), text.length());
                }
            }
        }
    }
}
