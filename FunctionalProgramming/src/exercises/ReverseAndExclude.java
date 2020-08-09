package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int divisionNumber = Integer.parseInt(reader.readLine());
        Collections.reverse(numbers);

        Predicate<Integer> isNotDivisible = n -> n % divisionNumber != 0;
        for (Integer number : numbers) {
            if (isNotDivisible.test(number)) {
                System.out.print(number + " ");
            }
        }

        System.out.println();
    }
}
