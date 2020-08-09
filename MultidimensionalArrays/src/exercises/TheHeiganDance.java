package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        final int CHAMBER_SIZE = 15;
        final int TOXIC_CLOUD_DAMAGE = 3500;
        final int ERUPTION_DAMAGE = 6000;
        final int PLAYER_STARTING_HEALTH = 18500;
        final int HEIGAN_STARTING_HEALTH = 3000000;
        Scanner scanner = new Scanner(System.in);

        char[][] bossChamber = new char[CHAMBER_SIZE][CHAMBER_SIZE];
        double playerDamage = Double.parseDouble(scanner.nextLine());
        int playerHealth = PLAYER_STARTING_HEALTH;
        double heiganHealth = HEIGAN_STARTING_HEALTH;

        for (char[] row : bossChamber) {
            Arrays.fill(row, 'o');
        }

        int playerRow = 7;
        int playerCol = 7;
        boolean shouldTakeToxicDamage = false;
        String spellType = "";

        while (playerHealth > 0) {
            if (shouldTakeToxicDamage) {
                playerHealth -= TOXIC_CLOUD_DAMAGE;
                shouldTakeToxicDamage = false;
            }

            heiganHealth -= playerDamage;

            if (playerHealth <= 0) {
                break;
            }

            if (heiganHealth <= 0) {
                break;
            }

            String[] spellParams = scanner.nextLine().split("\\s+");
            spellType = spellParams[0];
            int spellRow = Integer.parseInt(spellParams[1]);
            int spellCol = Integer.parseInt(spellParams[2]);

            for (int row = Math.max(spellRow - 1, 0); row <= Math.min(spellRow + 1, bossChamber.length - 1); row++) {
                for (int col = Math.max(spellCol - 1, 0); col <= Math.min(spellCol + 1, bossChamber[row].length - 1); col++) {
                    bossChamber[row][col] = 'd';
                }
            }

            if (bossChamber[playerRow][playerCol] == 'd') {
                if (playerRow - 1 >= 0
                        && bossChamber[playerRow - 1][playerCol] != 'd') {
                    playerRow--;
                } else if (playerCol + 1 < bossChamber[playerRow].length
                        && bossChamber[playerRow][playerCol + 1] != 'd') {
                    playerCol++;
                } else if (playerRow + 1 < bossChamber.length
                        && bossChamber[playerRow + 1][playerCol] != 'd') {
                    playerRow++;
                } else if (playerCol - 1 >= 0
                        && bossChamber[playerRow][playerCol - 1] != 'd') {
                    playerCol--;
                } else {
                    if (spellType.equalsIgnoreCase("Cloud")) {
                        playerHealth -= TOXIC_CLOUD_DAMAGE;
                        shouldTakeToxicDamage = true;
                    } else if (spellType.equalsIgnoreCase("Eruption")) {
                        playerHealth -= ERUPTION_DAMAGE;
                    }
                }
            }

            for (int row = Math.max(spellRow - 1, 0); row <= Math.min(spellRow + 1, bossChamber.length - 1); row++) {
                for (int col = Math.max(spellCol - 1, 0); col <= Math.min(spellCol + 1, bossChamber[row].length - 1); col++) {
                    bossChamber[row][col] = 'o';
                }
            }
        }

        if (heiganHealth <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHealth);
        }

        if (playerHealth <= 0) {
            System.out.printf("Player: Killed by %s%n",
                    spellType.equalsIgnoreCase("Cloud") ? "Plague Cloud" : "Eruption");
        } else if (heiganHealth <= 0) {
            System.out.println("Player: " + playerHealth);
        }

        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
    }
}
