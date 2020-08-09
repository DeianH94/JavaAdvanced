package lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixRows = Integer.parseInt(scanner.nextLine());
        int matrixColumns = Integer.parseInt(scanner.nextLine());
        
        String[][] firstMatrix = new String[matrixRows][matrixColumns];
        String[][] secondMatrix = new String[matrixRows][matrixColumns];
        String[][] resultMatrix = new String[matrixRows][matrixColumns];

        fillMatrix(scanner, firstMatrix);
        fillMatrix(scanner, secondMatrix);

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    resultMatrix[row][col] = firstMatrix[row][col];
                } else {
                    resultMatrix[row][col] = "*";
                }
            }
        }

        for (String[] matrix : resultMatrix) {
            System.out.println(String.join(" ", matrix));
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");;
        }
    }
}
