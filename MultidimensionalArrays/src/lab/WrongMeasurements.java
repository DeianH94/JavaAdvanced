package lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixDimensions = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixDimensions][matrixDimensions];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] wrongValueCoordinates = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        matrix = changeWrongValues(matrix, wrongValueCoordinates);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static int[][] changeWrongValues(int[][] matrix, int[] wrongValueCoordinates) {
        int wrongRow = wrongValueCoordinates[0];
        int wrongCol = wrongValueCoordinates[1];
        int wrongValue = matrix[wrongRow][wrongCol];
        int[][] fixedMatrix = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    int newValue = 0;
                    if (row > 0 && matrix[row - 1][col] != wrongValue) {
                        newValue += matrix[row - 1][col];
                    }

                    if (row < matrix.length - 1 && matrix[row + 1][col] != wrongValue) {
                        newValue += matrix[row + 1][col];
                    }

                    if (col > 0 && matrix[row][col - 1] != wrongValue) {
                        newValue += matrix[row][col - 1];
                    }

                    if (col < matrix[row].length - 1 && matrix[row][col + 1] != wrongValue) {
                        newValue += matrix[row][col + 1];
                    }

                    fixedMatrix[row][col] = newValue;
                }
            }
        }

        return fixedMatrix;
    }
}
