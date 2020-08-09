package lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = createMatrixFromConsole(scanner);

        int[][] secondMatrix = createMatrixFromConsole(scanner);

        boolean matricesAreEqual = matricesAreEqual(firstMatrix, secondMatrix);

        System.out.println(matricesAreEqual ? "equal" : "not equal");
    }

    private static int[][] createMatrixFromConsole(Scanner scanner) {
        int[] matrixDimensions = Arrays.stream(scanner.nextLine()
                .split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int matrixRows = matrixDimensions[0];
        int matrixCols = matrixDimensions[1];
        int[][] matrix = new int[matrixRows][matrixCols];

        for (int i = 0; i < matrix.length; i++) {
            int[] arr = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = arr;
        }

        return matrix;
    }

    private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }

            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
