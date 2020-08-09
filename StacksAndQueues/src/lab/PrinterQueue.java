package lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> fileNames = new ArrayDeque<>();
        String filename = scanner.nextLine();

        while (!filename.equalsIgnoreCase("print")) {
            if (filename.equalsIgnoreCase("cancel")) {
                if (!fileNames.isEmpty()) {
                    System.out.println("Canceled " + fileNames.pollFirst());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                fileNames.offer(filename);
            }

            filename = scanner.nextLine();
        }

        while (!fileNames.isEmpty()) {
            System.out.println(fileNames.pollFirst());
        }
    }
}
