package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lairDiemsions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lairRows = lairDiemsions[0];
        int lairCols = lairDiemsions[1];
        char[][] lair = new char[lairRows][lairCols];

        int playerRow = 0;
        int playerCol = 0;
        for (int row = 0; row < lair.length; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < lair[row].length; col++) {
                lair[row][col] = line[col];

                if (lair[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }


        char[] playerMoves = scanner.nextLine().toCharArray();
        boolean wonTheGame = false;
        boolean isDead = false;
        for (char playerMove : playerMoves) {
            lair[playerRow][playerCol] = '.';
            boolean escaped = (playerRow == 0 && playerMove == 'U')
                    || (playerRow == lair.length - 1 && playerMove == 'D')
                    || (playerCol == 0 && playerMove == 'L')
                    || (playerCol == lair[playerRow].length - 1&& playerMove == 'R');
            if (escaped) {
                wonTheGame = true;
            } else if (playerMove == 'U') {
                playerRow--;
            } else if (playerMove == 'D') {
                playerRow++;
            } else if (playerMove == 'L') {
                playerCol--;
            } else if (playerMove == 'R') {
                playerCol++;
            }

            char[][] rabbitsMultiplication = Arrays.stream(lair).map(char[]::clone).toArray(char[][]::new);
            for (int row = 0; row < lair.length; row++) {
                for (int col = 0; col < lair[row].length; col++) {
                    if (lair[row][col] != 'B') {
                        continue;
                    }

                    if (row > 0) {
                        rabbitsMultiplication[row - 1][col] = 'B';
                    }

                    if (row < lair.length - 1) {
                        rabbitsMultiplication[row + 1][col] = 'B';
                    }

                    if (col > 0) {
                        rabbitsMultiplication[row][col - 1] = 'B';
                    }

                    if (col < lair[row].length - 1) {
                        rabbitsMultiplication[row][col + 1] = 'B';
                    }
                }
            }

            lair = rabbitsMultiplication;

            if (lair[playerRow][playerCol] == 'B') {
                isDead = true;
            } else if (!wonTheGame) {
                lair[playerRow][playerCol] = 'P';
            }

            if (wonTheGame || isDead) {
                break;
            }
        }

        for (int row = 0; row < lair.length; row++) {
            for (int col = 0; col < lair[row].length; col++) {
                System.out.print(lair[row][col]);
            }

            System.out.println();
        }

        System.out.printf("%s: %d %d%n", wonTheGame ? "won" : "dead", playerRow, playerCol);
    }
}
