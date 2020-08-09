package lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(LinkedHashSet::new));;

        Set<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50; i++) {
            int firstPlayerTopCard = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstPlayerTopCard);

            int secondPlayerTopCard = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondPlayerTopCard);

            if (firstPlayerTopCard > secondPlayerTopCard) {
                firstPlayerCards.add(firstPlayerTopCard);
                firstPlayerCards.add(secondPlayerTopCard);
            } else if (secondPlayerTopCard > firstPlayerTopCard) {
                secondPlayerCards.add(firstPlayerTopCard);
                secondPlayerCards.add(secondPlayerTopCard);
            }

            if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()) {
                break;
            }
        }

        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (firstPlayerCards.size() < secondPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }
}
