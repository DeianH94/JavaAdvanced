package exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        final String SHARDS = "shards";
        final String FRAGMENTS = "fragments";
        final String MOTES = "motes";
        final int RESOURCES_FOR_LEGENDARY = 250;
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyResources = new LinkedHashMap<>();
        keyResources.put(SHARDS, 0);
        keyResources.put(FRAGMENTS, 0);
        keyResources.put(MOTES, 0);

        Map<String, Integer> junk = new LinkedHashMap<>();
        boolean obtainedLegendary = false;

        while (!obtainedLegendary) {
            String[] inputLine = scanner.nextLine().split("\\s+");

            for (int i = 0; i < inputLine.length; i += 2) {
                int resourceQuantity = Integer.parseInt(inputLine[i]);
                String resourceType = inputLine[i + 1].toLowerCase();

                if (!resourceType.equals(SHARDS)
                        && !resourceType.equals(FRAGMENTS)
                        && !resourceType.equals(MOTES)) {
                    if (!junk.containsKey(resourceType)) {
                        junk.put(resourceType, 0);
                    }

                    junk.put(resourceType, junk.get(resourceType) + resourceQuantity);
                } else {
                    keyResources.put(resourceType, keyResources.get(resourceType) + resourceQuantity);
                }

                if (keyResources.containsKey(SHARDS) && keyResources.get(SHARDS) >= RESOURCES_FOR_LEGENDARY) {
                    System.out.println("Shadowmourne obtained!");
                    keyResources.put(SHARDS, keyResources.get(SHARDS) - RESOURCES_FOR_LEGENDARY);
                    obtainedLegendary = true;
                    break;
                }

                if (keyResources.containsKey(FRAGMENTS) && keyResources.get(FRAGMENTS) >= RESOURCES_FOR_LEGENDARY) {
                    System.out.println("Valanyr obtained!");
                    keyResources.put(FRAGMENTS, keyResources.get(FRAGMENTS) - RESOURCES_FOR_LEGENDARY);
                    obtainedLegendary = true;
                    break;
                }

                if (keyResources.containsKey(MOTES) && keyResources.get(MOTES) >= RESOURCES_FOR_LEGENDARY) {
                    System.out.println("Dragonwrath obtained!");
                    keyResources.put(MOTES, keyResources.get(MOTES) - RESOURCES_FOR_LEGENDARY);
                    obtainedLegendary = true;
                    break;
                }
            }
        }

        keyResources.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted((r1, r2) -> r2.getValue().compareTo(r1.getValue()))
                .forEach(r -> System.out.printf("%s: %d%n", r.getKey(), r.getValue()));

        junk.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(j -> System.out.printf("%s: %d%n", j.getKey(), j.getValue()));
    }
}
