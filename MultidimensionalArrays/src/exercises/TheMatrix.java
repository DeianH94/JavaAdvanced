package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numOfRows = matrixDimensions[0];
        int numOfCols = matrixDimensions[1];
        Character[][] matrix = new Character[numOfRows][numOfCols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine()
                    .chars()
                    .filter(c -> c != ' ')
                    .mapToObj(c -> (char) c)
                    .toArray(Character[]::new);
        }

        char fillChar = scanner.nextLine().charAt(0);
        int[] startingCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startRow = startingCoordinates[0];
        int startCol = startingCoordinates[1];
        char startChar = matrix[startRow][startCol];

        replaceCharInMatrix(matrix, startRow, startCol, fillChar, startChar);

        for (Character[] row : matrix) {
            for (Character character : row) {
                System.out.print(character);
            }

            System.out.println();
        }
    }

    private static void replaceCharInMatrix(Character[][] matrix, int row, int col, char fillChar, char startChar) {
        if (matrix[row][col] != startChar) {
            return;
        }

        matrix[row][col] = fillChar;

        if (row + 1 < matrix.length) {
            replaceCharInMatrix(matrix, row + 1, col, fillChar, startChar);
        }

        if (row - 1 >= 0) {
            replaceCharInMatrix(matrix, row - 1, col, fillChar, startChar);
        }

        if (col + 1 < matrix[row].length) {
            replaceCharInMatrix(matrix, row, col + 1, fillChar, startChar);
        }

        if (col - 1 >= 0) {
            replaceCharInMatrix(matrix, row, col - 1, fillChar, startChar);
        }
    }
}
