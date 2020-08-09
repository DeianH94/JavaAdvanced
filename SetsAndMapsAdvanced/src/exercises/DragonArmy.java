package exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) {
        final int DEFAULT_HEALTH = 250;
        final int DEFAULT_DAMAGE = 45;
        final int DEFAULT_ARMOR = 10;
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Map<String, int[]>> dragons = new LinkedHashMap<>();
        int numOfDragons = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfDragons; i++) {
            String[] dragonData = scanner.nextLine().split("\\s+");
            String type = dragonData[0];
            String name = dragonData[1];
            int damage = DEFAULT_DAMAGE;
            int health = DEFAULT_HEALTH;
            int armor = DEFAULT_ARMOR;
            if (!dragonData[2].equalsIgnoreCase("null")) {
                damage = Integer.parseInt(dragonData[2]);
            }

            if (!dragonData[3].equalsIgnoreCase("null")) {
                health = Integer.parseInt(dragonData[3]);
            }

            if (!dragonData[4].equalsIgnoreCase("null")) {
                armor = Integer.parseInt(dragonData[4]);
            }

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).put(name, new int[]{damage, health, armor});
        }

        dragons.forEach((dragonType, dragonInfo) -> {
            double damageAvr = dragonInfo.values().stream()
                    .map(ints -> ints[0])
                    .mapToInt(Integer::intValue)
                    .average()
                    .getAsDouble();
            double healthAvr = dragonInfo.values().stream()
                    .map(ints -> ints[1])
                    .mapToInt(Integer::intValue)
                    .average()
                    .getAsDouble();
            double armorAvr = dragonInfo.values().stream()
                    .map(ints -> ints[2])
                    .mapToInt(Integer::intValue)
                    .average()
                    .getAsDouble();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", dragonType, damageAvr, healthAvr, armorAvr);

            dragonInfo.forEach((dragonName, dragonStats) ->
                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                            dragonName,
                            dragonStats[0],
                            dragonStats[1],
                            dragonStats[2]));
        });
    }
}
