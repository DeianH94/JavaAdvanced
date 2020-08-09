package lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrixFromConsole(scanner);
        int numberToFind = Integer.parseInt(scanner.nextLine());
        boolean foundOne = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == numberToFind) {
                    System.out.println(row + " " + col);
                    foundOne = true;
                }
            }
        }

        if (!foundOne) {
            System.out.println("not found");
        }
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
}
