package exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> charOccurrences = new TreeMap<>();
        String line = scanner.nextLine();

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            charOccurrences.putIfAbsent(currentChar, 0);
            charOccurrences.put(currentChar, charOccurrences.get(currentChar) + 1);
        }

        for (var character : charOccurrences.entrySet()) {
            System.out.printf("%s: %d time/s%n", character.getKey(), character.getValue());
        }
    }
}
