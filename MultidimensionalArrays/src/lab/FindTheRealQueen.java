package lab;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Character[][] matrix = new Character[8][8];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .map(c -> c.charAt(0))
                    .toArray(Character[]::new);
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q') {
                    if (checkIfValid(matrix, row, col)) {
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }
    }

    private static boolean checkIfValid(Character[][] matrix, int centerRow, int centerCol) {
        for (int i = 0; i < centerRow; i++) {
            if (matrix[i][centerCol] == 'q') {
                return false;
            }
        }

        for (int i = centerRow + 1; i < matrix.length; i++) {
            if (matrix[i][centerCol] == 'q') {
                return false;
            }
        }

        for (int i = 0; i < centerCol; i++) {
            if (matrix[centerRow][i] == 'q') {
                return false;
            }
        }

        for (int i = centerCol + 1; i < matrix[centerRow].length; i++) {
            if (matrix[centerRow][i] == 'q') {
                return false;
            }
        }

        int currentCol = centerCol - 1;
        int currentRow = centerRow - 1;
        while (currentRow > 0 && currentCol > 0) {
            if (matrix[currentRow][currentCol] == 'q') {
                return false;
            }

            currentRow--;
            currentCol--;
        }

        currentCol = centerCol + 1;
        currentRow = centerRow - 1;
        while (currentRow > 0 && currentCol < matrix[centerRow].length) {
            if (matrix[currentRow][currentCol] == 'q') {
                return false;
            }

            currentRow--;
            currentCol++;
        }

        currentCol = centerCol - 1;
        currentRow = centerRow + 1;
        while (currentRow < matrix.length && currentCol > 0) {
            if (matrix[currentRow][currentCol] == 'q') {
                return false;
            }

            currentRow++;
            currentCol--;
        }

        currentCol = centerCol + 1;
        currentRow = centerRow + 1;
        while (currentRow < matrix.length && currentCol < matrix[currentRow].length) {
            if (matrix[currentRow][currentCol] == 'q') {
                return false;
            }

            currentRow++;
            currentCol++;
        }

        return true;
    }
}
