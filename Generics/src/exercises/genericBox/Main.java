package exercises.genericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLines; i++) {
            Box<String> box = new Box<>(scanner.nextLine());
            System.out.println(box);
        }
    }
}
