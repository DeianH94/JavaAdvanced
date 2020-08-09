package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] range = reader.readLine().split("\\s+");
        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);
        String condition = reader.readLine();

        Predicate<Integer> tester = createTester(condition);

        for (int i = start; i <= end; i++) {
            if (tester.test(i)) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }

    static Predicate<Integer> createTester(String condition) {
        Predicate<Integer> tester = null;

        switch (condition) {
            case "even":
                tester = x -> x % 2 == 0;
                break;
            case "odd":
                tester = x -> x % 2 != 0;
                break;
        }

        return tester;
    }
}
