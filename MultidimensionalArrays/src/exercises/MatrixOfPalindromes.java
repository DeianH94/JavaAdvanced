package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] matrixData = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int matrixRows = matrixData[0];
        int matrixCols = matrixData[1];
        String[][] matrix = fillMatrix(matrixRows, matrixCols);

        printMatrix(matrix);
    }

    private static String[][] fillMatrix(int matrixRows, int matrixCols) {
        String[][] matrix = new String[matrixRows][matrixCols];

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.valueOf(alphabet[row]) + alphabet[row + col] + alphabet[row];
            }
        }

        return matrix;
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
