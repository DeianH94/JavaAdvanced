package lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int matrixRows = matrixDimensions[0];
        int matrixColumns = matrixDimensions[1];

        int[][] matrix = new int[matrixRows][matrixColumns];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int matrixSum = 0;
        for (int[] row : matrix) {
            for (int col = 0; col < row.length; col++) {
                matrixSum += row[col];
            }
        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(matrixSum);
    }
}
