package exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!name.equalsIgnoreCase("stop")) {
            String email = scanner.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emails.put(name, email);
            }

            name = scanner.nextLine();
        }

        for (var email : emails.entrySet()) {
            System.out.println(email.getKey() + " -> " + email.getValue());
        }
    }
}
