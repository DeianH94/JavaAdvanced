package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> peopleMap = new LinkedHashMap<>();

        int numOfPeople = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numOfPeople; i++) {
            String[] params = reader.readLine().split(",\\s+");
            String name = params[0];
            int age = Integer.parseInt(params[1]);

            peopleMap.putIfAbsent(name, age);
        }

        String condition = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);

        for (Map.Entry<String, Integer> person : peopleMap.entrySet()) {
            if (tester.test(peopleMap.get(person.getKey()))) {
                printer.accept(person);
            }
        }
    }

    static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {

        Consumer<Map.Entry<String, Integer>> printer = null;

        switch (format) {
            case "name age":
                printer = person -> System.out.printf("%s - %d%n",
                        person.getKey(), person.getValue());
                break;
            case "name":
                printer = person -> System.out.printf("%s%n", person.getKey());
                break;
            case "age":
                printer = person -> System.out.printf("%d%n", person.getValue());
                break;
        }

        return printer;
    }

    static Predicate<Integer> createTester(String condition, Integer age) {

        Predicate<Integer> tester = null;

        switch (condition) {
            case "younger":
                tester = x -> x <= age;
                break;
            case "older":
                tester = x -> x >= age;
                break;
        }

        return tester;
    }
}
