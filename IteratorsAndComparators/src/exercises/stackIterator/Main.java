package exercises.stackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();
        Stack<Integer> stack = new Stack<>();

        while (!command.equalsIgnoreCase("end")) {
            if (command.startsWith("Push")) {
                int[] params = Arrays.stream(command.split(",?\\s++"))
                        .skip(1)
                        .mapToInt(Integer::parseInt)
                        .toArray();

                for (int param : params) {
                    stack.push(param);
                }
            } else if (command.equals("Pop")) {
                try {
                    stack.pop();
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            command = reader.readLine();
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
