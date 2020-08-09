package exercises.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        ListyIterator iterator = new ListyIterator();

        while (!command.equalsIgnoreCase("end")) {
            String[] params = command.split("\\s+");

            try {
                switch (params[0].toLowerCase()) {
                    case "create":
                        String[] elements = Arrays.stream(params, 1, params.length).toArray(String[]::new);
                        iterator = new ListyIterator<>(elements);
                        break;
                    case "move":
                        System.out.println(iterator.move());
                        break;
                    case "print":
                        iterator.print();
                        break;
                    case "hasnext":
                        System.out.println(iterator.hasNext());
                        break;
                    case "printall":
                        iterator.printAll();
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }


            command = reader.readLine();
        }
    }
}
