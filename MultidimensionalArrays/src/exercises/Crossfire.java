package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int matrixRows = matrixDimensions[0];
        int matrixColumns = matrixDimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();

        for (int row = 0; row < matrixRows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < matrixColumns; col++) {
                matrix.get(row).add(row * matrixColumns + col + 1);
            }
        }

        String command = scanner.nextLine();

        while (!command.equalsIgnoreCase("Nuke it from orbit")) {
            launchNuke(matrix, command);

            command = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static void launchNuke(List<List<Integer>> matrix, String command) {
        int[] nukeParams = Arrays.stream(command.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int targetRow = nukeParams[0];
        int targetCol = nukeParams[1];
        int radius = nukeParams[2];

        for (int row = targetRow + radius; row >= targetRow - radius; row--) {
            if (checkIfCoordinatesExists(matrix, row, targetCol) && row != targetRow) {
                matrix.get(row).remove(targetCol);
            }
        }

        for (int col = targetCol + radius; col >= targetCol - radius; col--) {
            if (checkIfCoordinatesExists(matrix, targetRow, col)) {
                matrix.get(targetRow).remove(col);
            }
        }

        if (targetRow >= 0 && targetRow < matrix.size() && matrix.get(targetRow).size() == 0) {
            matrix.remove(targetRow);
        }
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                System.out.print(matrix.get(row).get(col) + " ");
            }

            System.out.println();
        }
    }

    private static boolean checkIfCoordinatesExists(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}
