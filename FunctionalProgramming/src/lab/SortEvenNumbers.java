package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> numbers = Arrays.stream(reader.readLine().split(",\\s++"))
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", numbers));

        numbers = numbers.stream()
                .map(Integer::parseInt)
                .sorted(Integer::compareTo)
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", numbers));
    }
}
