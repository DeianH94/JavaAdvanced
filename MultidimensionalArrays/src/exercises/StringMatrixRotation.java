package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rotateData = Integer.parseInt(input.substring(input.indexOf('(') + 1, input.length() - 1));
        int rotateAngle = rotateData % 360;
        List<String> inputLines = new ArrayList<>();
        int maxlength = 0;
        String inputLine = scanner.nextLine();
        while (!inputLine.equalsIgnoreCase("end")) {
            if (inputLine.length() > maxlength) {
                maxlength = inputLine.length();
            }

            inputLines.add(inputLine);

            inputLine = scanner.nextLine();
        }

        char[][] matrix;

        if (rotateAngle == 0) {
            matrix = fillMatrixZeroDegrees(inputLines, maxlength);
        } else if (rotateAngle == 90) {
            matrix = fillMatrix90Degrees(inputLines, maxlength);
        } else if (rotateAngle == 180) {
            matrix = fillMatrix180Degrees(inputLines, maxlength);
        } else {
            matrix = fillMatrix270Degrees(inputLines, maxlength);
        }

        printMatrix(matrix);
    }

    private static char[][] fillMatrixZeroDegrees(List<String> inputLines, int maxLength) {
        char[][] matrix = new char[inputLines.size()][maxLength];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col >= inputLines.get(row).length()) {
                    matrix[row][col] = ' ';
                } else {
                    matrix[row][col] = inputLines.get(row).charAt(col);
                }
            }
        }

        return matrix;
    }

    private static char[][] fillMatrix90Degrees(List<String> inputLines, int maxLength) {
        char[][] matrix = new char[maxLength][inputLines.size()];
        int currentStringIndex = 0;

        for (int col = inputLines.size() - 1; col >= 0; col--) {
            for (int row = 0; row < matrix.length; row++) {
                if (row >= inputLines.get(currentStringIndex).length()) {
                    matrix[row][col] = ' ';
                } else {
                    matrix[row][col] = inputLines.get(currentStringIndex).charAt(row);
                }
            }

            currentStringIndex++;
        }

        return matrix;
    }

    private static char[][] fillMatrix180Degrees(List<String> inputLines, int maxLength) {
        char[][] matrix = new char[inputLines.size()][maxLength];
        int currentStringIndex = 0;

        for (int row = matrix.length - 1; row >= 0; row--) {
            int currentCharIndex = 0;
            for (int col = matrix[row].length - 1; col >= 0; col--) {
                if (col < matrix[row].length - inputLines.get(currentStringIndex).length()) {
                    matrix[row][col] = ' ';
                } else {
                    matrix[row][col] = inputLines.get(currentStringIndex).charAt(currentCharIndex);
                    currentCharIndex++;
                }
            }

            currentStringIndex++;
        }

        return matrix;
    }

    private static char[][] fillMatrix270Degrees(List<String> inputLines, int maxLength) {
        char[][] matrix = new char[maxLength][inputLines.size()];

        for (int col = 0; col < inputLines.size(); col++) {
            int currentCharIndex = 0;
            for (int row = matrix.length - 1; row >= 0; row--) {
                if (row < matrix.length - inputLines.get(col).length()) {
                    matrix[row][col] = ' ';
                } else {
                    matrix[row][col] = inputLines.get(col).charAt(currentCharIndex);
                    currentCharIndex++;
                }
            }
        }

        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }
}
