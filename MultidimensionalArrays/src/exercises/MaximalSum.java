package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int matrixRows = matrixDimensions[0];
        int matrixColumns = matrixDimensions[1];

        int[][] matrix = new int[matrixRows][matrixColumns];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int bestSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col]
                        + matrix[row + 1][col]
                        + matrix[row][col + 1]
                        + matrix[row + 1][col + 1]
                        + matrix[row + 2][col]
                        + matrix[row + 2][col + 1]
                        + matrix[row][col + 2]
                        + matrix[row + 1][col + 2]
                        + matrix[row + 2][col + 2];

                if (sum > bestSum) {
                    bestSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        System.out.println("Sum = " + bestSum);
        for (int row = bestRow; row < bestRow + 3; row++) {
            System.out.printf("%d %d %d%n",
                    matrix[row][bestCol],
                    matrix[row][bestCol + 1],
                    matrix[row][bestCol + 2]);
        }
    }
}
