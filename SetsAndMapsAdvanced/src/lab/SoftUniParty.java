package lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String guestId = scanner.nextLine();
        while (!guestId.equalsIgnoreCase("party")) {
            if (Character.isDigit(guestId.charAt(0))) {
                vip.add(guestId);
            } else {
                regular.add(guestId);
            }

            guestId = scanner.nextLine();
        }

        guestId = scanner.nextLine();
        while (!guestId.equalsIgnoreCase("end")) {
            if (Character.isDigit(guestId.charAt(0))) {
                vip.remove(guestId);
            } else {
                regular.remove(guestId);
            }

            guestId = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());
        vip.forEach(System.out::println);
        regular.forEach(System.out::println);
    }
}
