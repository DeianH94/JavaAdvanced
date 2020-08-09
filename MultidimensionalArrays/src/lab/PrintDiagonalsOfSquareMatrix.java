package lab;

import java.util.*;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixDimensions = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixDimensions][matrixDimensions];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        List<Integer> firstDiagonal = new ArrayList<>();
        List<Integer> secondDiagonal = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            firstDiagonal.add(matrix[i][i]);
            secondDiagonal.add(matrix[i][matrix.length - 1 - i]);
        }

        Collections.reverse(secondDiagonal);

        printMatrixDiagonal(firstDiagonal);
        printMatrixDiagonal(secondDiagonal);
    }

    private static void printMatrixDiagonal(List<Integer> firstDiagonal) {
        for (Integer digit : firstDiagonal) {
            System.out.print(digit + " ");
        }

        System.out.println();
    }
}
