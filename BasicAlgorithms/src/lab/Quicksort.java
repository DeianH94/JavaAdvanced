package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(numbers);

        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();
    }

    private static void sort(int[] numbers) {
        sort(numbers, 0, numbers.length - 1);
    }

    private static void sort(int[] numbers, int low, int high) {
        if (low < high) {
            int pi = partition(numbers, low, high);

            sort(numbers, low, pi - 1);
            sort(numbers, pi + 1, high);
        }
    }

    private static int partition(int[] numbers, int low, int high) {
        int pivot = numbers[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (numbers[j] <= pivot) {
                i++;

                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }

        int temp = numbers[i + 1];
        numbers[i + 1] = numbers[high];
        numbers[high] = temp;

        return i + 1;
    }
}
