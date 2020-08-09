package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = reader.readLine();


        while (!command.equalsIgnoreCase("end")) {
            if (command.equalsIgnoreCase("print")) {
                for (int number : numbers) {
                    System.out.print(number + " ");
                }

                System.out.println();
            } else {
                Function<Integer, Integer> applyOperation = determineOperation(command);
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = applyOperation.apply(numbers[i]);
                }
            }

            command = reader.readLine();
        }
    }

    static Function<Integer, Integer> determineOperation(String operationName) {
        Function<Integer, Integer> operation = null;

        switch (operationName.toLowerCase()) {
            case "add":
                operation = num -> num = num + 1;
                break;
            case "multiply":
                operation = num -> num = num * 2;
                break;
            case "subtract":
                operation = num -> num = num - 1;
                break;
        }

        return operation;
    }
}
