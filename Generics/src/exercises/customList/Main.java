package exercises.customList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String[] commandParams = scanner.nextLine().split("\\s+");
        while (!commandParams[0].equalsIgnoreCase("end")) {
            String commandType = commandParams[0];
            switch (commandType.toLowerCase()) {
                case "add":
                    String elementToAdd = commandParams[1];
                    customList.add(elementToAdd);
                    break;
                case "remove":
                    int index = Integer.parseInt(commandParams[1]);
                    customList.remove(index);
                    break;
                case "contains":
                    String elementToFind = commandParams[1];
                    System.out.println(customList.contains(elementToFind));
                    break;
                case "swap":
                    int firstIndex = Integer.parseInt(commandParams[1]);
                    int secondIndex = Integer.parseInt(commandParams[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "greater":
                    String elementToCompare = commandParams[1];
                    System.out.println(customList.countGreaterThan(elementToCompare));
                    break;
                case "max":
                    System.out.println(customList.getMax());
                    break;
                case "min":
                    System.out.println(customList.getMin());
                    break;
                case "print":
                    customList.forEach(System.out::println);
                    break;
                case "sort":
                    Sorter.sort(customList);
                    break;
            }

            commandParams = scanner.nextLine().split("\\s+");
        }
    }
}
