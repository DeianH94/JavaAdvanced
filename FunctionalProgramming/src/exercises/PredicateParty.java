package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = reader.readLine();
        

        while (!command.equalsIgnoreCase("party!")) {
            String[] params = command.split("\\s+");
            Predicate<String> predicate = createPredicate(params[1], params[2]);
            List<String> temp = new ArrayList<>();

            for (String name : names) {
                if (predicate.test(name)) {
                    temp.add(name);
                }
            }

            if (params[0].equalsIgnoreCase("remove")) {
                names.removeAll(temp);
            } else {
                names.addAll(temp);
            }

            command = reader.readLine();
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(names.stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.joining(", ")) + " are going to the party!");
        }
    }

    private static Predicate<String> createPredicate(String command, String param) {
        Predicate<String> predicate = null;

        switch(command.toLowerCase()) {
            case "startswith":
                predicate = e -> e.startsWith(param);
                break;
            case "endswith":
                predicate = e -> e.endsWith(param);
                break;
            case "length":
                predicate = e -> e.length() == Integer.parseInt(param);
                break;
        }

        return predicate;
    }
}
