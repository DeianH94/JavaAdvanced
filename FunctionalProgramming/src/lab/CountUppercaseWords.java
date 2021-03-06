package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = reader.readLine().split("\\s+");

        Predicate<String> checkUpperCase = word -> Character.isUpperCase(word.charAt(0));

        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (checkUpperCase.test(word)) {
                result.add(word);
            }
        }

        System.out.println(result.size());

        for (String word : result) {
            System.out.println(word);
        }
    }
}
