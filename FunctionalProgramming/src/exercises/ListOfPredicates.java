package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Set<Integer> sequence = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        BiPredicate<Integer, Integer> predicate = (f, s) ->  f % s == 0;

        for (int i = 1; i <= n; i++) {
            boolean isValid = true;

            for (Integer number : sequence) {
                if (!predicate.test(i, number)) {
                    isValid = false;
                    break;
                }
            }

            if(isValid) {
                System.out.print(i + " ");
            }
        }
    }
}
