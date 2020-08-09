package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecursiveArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(sum(numbers, numbers.length - 1));
    }

    private static int sum(int[] nums, int index) {
        if (index == 0) {
            return nums[index];
        } else {
            return nums[index] + sum(nums, index - 1);
        }
    }
}
