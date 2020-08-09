package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] parkingLotDiemsions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean[][] parkingLot = new boolean[parkingLotDiemsions[0]][parkingLotDiemsions[1]];

        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("stop")) {
            int[] parkingParams = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int entryRow = parkingParams[0];
            int desiredRow = parkingParams[1];
            int desiredCol = parkingParams[2];

            int occupiedSpacesOnRow = 0;
            for (int col = 1; col < parkingLot[desiredRow].length; col++) {
                if (parkingLot[desiredRow][col]) {
                    occupiedSpacesOnRow++;
                }
            }

            command = scanner.nextLine();

            if (occupiedSpacesOnRow == parkingLot[desiredRow].length - 1) {
                System.out.println("Row " + desiredRow + " full");
                continue;
            }

            int leftCol = Integer.MAX_VALUE;
            int leftDistance = Integer.MAX_VALUE;
            int rightCol = Integer.MAX_VALUE;
            int rightDistance = Integer.MAX_VALUE;
            if (parkingLot[desiredRow][desiredCol]) {
                for (int col = desiredCol - 1; col > 0; col--) {
                    if (!parkingLot[desiredRow][col]) {
                        leftCol = col;
                        leftDistance = desiredCol - col;
                        break;
                    }
                }

                for (int col = desiredCol + 1; col < parkingLot[desiredRow].length; col++) {
                    if (!parkingLot[desiredRow][col]) {
                        rightCol = col;
                        rightDistance = col - desiredCol;
                        break;
                    }
                }

                if (rightDistance < leftDistance) {
                    desiredCol = rightCol;
                } else {
                    desiredCol = leftCol;
                }

            }

            parkingLot[desiredRow][desiredCol] = true;
            int distance = desiredCol + Math.abs(desiredRow - entryRow) + 1;
            System.out.println(distance);
        }
    }
}
