package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = reader.readLine();
        Map<String, Predicate<String>> predicates = new HashMap<>();

        while (!command.equalsIgnoreCase("print")) {
            String[] params = command.split(";");
            Predicate<String> predicate = createPredicate(params[1], params[2]);

            if (params[0].equalsIgnoreCase("add filter")) {
                predicates.putIfAbsent(params[1] + params[2], predicate);
            } else {
                predicates.remove(params[1] + params[2]);
            }

            command = reader.readLine();
        }

        names.stream().filter(n -> {
            boolean isValid = true;
            for(Predicate<String> predicate : predicates.values()) {
                if (predicate.test(n)) {
                    isValid = false;
                }
            }

            return isValid;
        }).forEach(e -> System.out.print(e + " "));
    }

    private static Predicate<String> createPredicate(String command, String param) {
        Predicate<String> predicate = null;

        switch(command.toLowerCase()) {
            case "starts with":
                predicate = e -> e.startsWith(param);
                break;
            case "ends with":
                predicate = e -> e.endsWith(param);
                break;
            case "length":
                predicate = e -> e.length() == Integer.parseInt(param);
                break;
            case "contains":
                predicate = e -> e.contains(param);
                break;

        }

        return predicate;
    }
}
