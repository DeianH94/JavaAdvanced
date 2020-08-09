package exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("search")) {
            String[] personData = command.split("-");
            String name = personData[0];
            String phoneNumber = personData[1];

            phoneBook.put(name, phoneNumber);

            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        while (!command.equalsIgnoreCase("stop")) {
            if (phoneBook.containsKey(command)) {
                System.out.println(command + " -> " + phoneBook.get(command));
            } else {
                System.out.println("Contact " + command + " does not exist.");
            }

            command = scanner.nextLine();
        }
    }
}
