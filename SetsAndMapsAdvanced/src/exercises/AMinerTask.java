package exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String resourceType = scanner.nextLine();
        while (!resourceType.equalsIgnoreCase("stop")) {
            int resourceQuantity = Integer.parseInt(scanner.nextLine());
            resources.putIfAbsent(resourceType, 0);
            resources.put(resourceType, resources.get(resourceType) + resourceQuantity);
            resourceType = scanner.nextLine();
        }

        for (var resource : resources.entrySet()) {
            System.out.println(resource.getKey() + " -> " + resource.getValue());
        }
    }
}
