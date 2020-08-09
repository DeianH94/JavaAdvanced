package exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> uniqueUsernames = new LinkedHashSet<>();
        int numOFUsernames = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOFUsernames; i++) {
            String newUsername = scanner.nextLine();
            uniqueUsernames.add(newUsername);
        }

        for (String username : uniqueUsernames) {
            System.out.println(username);
        }
    }
}
