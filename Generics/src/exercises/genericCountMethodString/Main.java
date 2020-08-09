package exercises.genericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        for (int i = 0; i < numOfLines; i++) {
            box.add(scanner.nextLine());
        }

        String stringToCompare = scanner.nextLine();
        System.out.println(box.countOfGraterElements(stringToCompare));
    }
}
