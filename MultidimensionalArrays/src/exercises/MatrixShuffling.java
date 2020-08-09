package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int matrixRows = matrixDimensions[0];
        int matrixColumns = matrixDimensions[1];

        String[][] matrix = new String[matrixRows][matrixColumns];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        String[] commandParams = scanner.nextLine().split("\\s+");

        while (!commandParams[0].equalsIgnoreCase("end")) {

            try {
                if (!commandParams[0].equalsIgnoreCase("swap")) {
                    throw new IllegalArgumentException();
                }

                int firstRow = Integer.parseInt(commandParams[1]);
                int firstCol = Integer.parseInt(commandParams[2]);
                int secondRow = Integer.parseInt(commandParams[3]);
                int secondCol = Integer.parseInt(commandParams[4]);

                boolean firstCoordinatesAreValid = firstRow >= 0
                        && firstCol >= 0
                        && firstRow < matrix.length
                        && firstCol < matrix[firstRow].length;
                boolean secondCoordinatesAreValid = secondRow >= 0
                        && secondCol >= 0
                        && secondRow < matrix.length
                        && secondCol < matrix[secondRow].length;
                if (firstCoordinatesAreValid && secondCoordinatesAreValid) {
                    String temp = matrix[firstRow][firstCol];
                    matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                    matrix[secondRow][secondCol] = temp;
                    printMatrix(matrix);
                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }

            commandParams = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }
}
