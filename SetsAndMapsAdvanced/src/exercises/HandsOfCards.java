package exercises;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playerCards = new LinkedHashMap<>();

        String[] playerData = scanner.nextLine().split(":\\s+");
        while (!playerData[0].equalsIgnoreCase("joker")) {
            String playerName = playerData[0];
            Set<String> cards = Arrays.stream(playerData[1].split(",\\s+"))
                    .collect(Collectors.toSet());
            playerCards.putIfAbsent(playerName, new HashSet<>());
            playerCards.get(playerName).addAll(cards);

            playerData = scanner.nextLine().split(":\\s+");
        }

        for (var player : playerCards.entrySet()) {
            int totalCardPower = 0;
            for (String card : player.getValue()) {
                totalCardPower += getCardPower(card);
            }

            System.out.println(player.getKey() + ": " + totalCardPower);
        }
    }

    private static int getCardPower(String card) {
        int cardPower = 0;

        switch (card.substring(0, card.length() - 1)) {
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
                cardPower = Integer.parseInt(card.substring(0, card.length() - 1));
                break;
            case "J":
                cardPower = 11;
                break;
            case "Q":
                cardPower = 12;
                break;
            case "K":
                cardPower = 13;
                break;
            case "A":
                cardPower = 14;
                break;
        }

        switch (card.charAt(card.length() - 1)) {
            case 'D':
                cardPower *= 2;
                break;
            case 'H':
                cardPower *= 3;
                break;
            case 'S':
                cardPower *= 4;
                break;
        }

        return cardPower;
    }
}
