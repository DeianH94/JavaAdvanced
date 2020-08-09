package exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
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

        Deque<Integer> rowPath = new ArrayDeque<>();
        Deque<Integer> colPath = new ArrayDeque<>();
        rowPath.push(startRow);
        colPath.push(startCol);
        boolean finished = false;
        while (!finished) {
            int currentRow = rowPath.pop();
            int currentCol = colPath.pop();
            int up = currentRow - 1;
            int left = currentCol - 1;
            if (up >= 0 && matrix[up][currentCol] == startChar && up != rowPath.peek()) {
                rowPath.push(currentRow);
                colPath.push(currentCol);
                rowPath.push(up);
                colPath.push(currentCol);
            } else if (left >= 0 && matrix[currentRow][left] == startChar && up != rowPath.peek()) {
                rowPath.push(currentRow);
                colPath.push(currentCol);
                rowPath.push(currentRow);
                colPath.push(left);
            } else if ()
        }
    }
}
