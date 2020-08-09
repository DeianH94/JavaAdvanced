package exercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixParams = scanner.nextLine().split(",\\s+");
        int matrixDimensions = Integer.parseInt(matrixParams[0]);
        String fillType = matrixParams[1];

        int[][] matrix;
        if (fillType.equalsIgnoreCase("A")) {
            matrix = fillPatternA(matrixDimensions);
        } else {
            matrix = fillPatternB(matrixDimensions);
        }

        printMatrix(matrix);
    }

    private static int[][] fillPatternB(int matrixDimensions) {
        int[][] matrix = new int[matrixDimensions][matrixDimensions];
        int count = 1;
        int col = 0;
        while (col < matrix[0].length) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = count;
                    count++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = count;
                    count++;
                }
            }

            col++;
        }

        return matrix;
    }

    private static int[][] fillPatternA(int matrixDimensions) {
        int[][] matrix = new int[matrixDimensions][matrixDimensions];
        int count = 1;

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = count;
                count++;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }
}
