package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int matrixRows = matrixDimensions[0];
        int matrixCols = matrixDimensions[1];
        int[][] matrix = new int[matrixRows][matrixCols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int col = matrix[matrix.length - 1].length - 1; col >= 0; col--) {
            int currentRow = matrix.length - 1;
            int currentCol = col;
            while (currentRow >= 0 && currentCol < matrix[currentRow].length) {
                System.out.print(matrix[currentRow][currentCol] + " ");
                currentRow--;
                currentCol++;
            }

            System.out.println();
        }

        for (int row = matrix.length - 2; row >= 0; row--) {
            int currentRow = row;
            int currentCol = 0;

            while (currentRow >= 0 && currentCol < matrix[currentRow].length) {
                System.out.print(matrix[currentRow][currentCol] + " ");
                currentRow--;
                currentCol++;
            }

            System.out.println();
        }
    }
}
