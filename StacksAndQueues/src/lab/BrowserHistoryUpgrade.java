package lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> back = new ArrayDeque<>();
        Deque<String> forward = new ArrayDeque<>();
        String line = scanner.nextLine();

        while (!line.equalsIgnoreCase("home")) {
            if (line.equalsIgnoreCase("back")) {
                if (back.size() > 1) {
                    forward.addFirst(back.pop());
                } else {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                }
            } else if (line.equalsIgnoreCase("forward")) {
                if (!forward.isEmpty()) {
                    back.push(forward.poll());
                } else {
                    System.out.println("no next URLs");
                    line = scanner.nextLine();
                    continue;
                }
            } else {
                back.push(line);
                forward.clear();
            }

            System.out.println(back.peek());
            line = scanner.nextLine();
        }
    }
}
