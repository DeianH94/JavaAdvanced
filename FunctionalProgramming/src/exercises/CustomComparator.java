package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(Comparator.comparingInt((Integer f) -> Math.abs(f % 2)).thenComparingInt(f -> f))
                .map(n -> n + " ")
                .forEach(System.out::print);
    }
}
