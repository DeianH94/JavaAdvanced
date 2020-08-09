package lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> towns = new LinkedHashMap<>();
        int numOfTowns = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfTowns; i++) {
            String[] townData = scanner.nextLine().split("\\s+");
            String continent = townData[0];
            String country = townData[1];
            String town = townData[2];
            towns.putIfAbsent(continent, new LinkedHashMap<>());
            towns.get(continent).putIfAbsent(country, new ArrayList<>());
            towns.get(continent).get(country).add(town);
        }

        for (var continent : towns.entrySet()) {
            System.out.println(continent.getKey() + ":");
            for (var country : continent.getValue().entrySet()) {
                System.out.printf(" %s -> %s%n", country.getKey(), String.join(", ", country.getValue()));
            }
        }
    }
}
