package exercises.froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(numbers);
        String endCommand = reader.readLine();
        StringBuilder sb = new StringBuilder();
        for (Integer num : lake) {
            sb.append(num).append(", ");
        }

        String output = sb.substring(0, sb.lastIndexOf(", "));
        System.out.println(output);
    }
}
