package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SumOfCoins {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().substring(7).split(",\\s+");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(reader.readLine().substring(5));

        try {
            Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

            System.out.println("Number of coins to take: "
                    + usedCoins.values().stream().reduce(0, Integer::sum));
            for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
                System.out.println(usedCoin.getValue() + " coin(s) with value " + usedCoin.getKey());
            }

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        List<Integer> sortedCoins = Arrays.stream(coins).boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        Map<Integer, Integer> chosenCoins = new LinkedHashMap<>();
        int currentSum = 0;
        int coinIndex = 0;

        while (currentSum != targetSum && coinIndex < sortedCoins.size()) {
            int currentCoin = sortedCoins.get(coinIndex);
            int remainder = targetSum - currentSum;
            int numberOfCoins = remainder / currentCoin;

            if (currentSum + currentCoin <= targetSum) {
                chosenCoins.put(currentCoin, numberOfCoins);
                currentSum += numberOfCoins * currentCoin;
            }

            coinIndex++;
        }

        if (currentSum != targetSum) {
            throw new IllegalArgumentException("Error");
        }

        return chosenCoins;
    }
}
