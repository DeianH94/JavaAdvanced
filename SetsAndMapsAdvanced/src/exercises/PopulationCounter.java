package exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> populationMap = new LinkedHashMap<>();

        String[] populationData = scanner.nextLine().split("\\|");
        while (!populationData[0].equalsIgnoreCase("report")) {
            String country = populationData[1];
            String city = populationData[0];
            long population = Long.parseLong(populationData[2]);

            populationMap.putIfAbsent(country, new LinkedHashMap<>());
            populationMap.get(country).put(city, population);

            populationData = scanner.nextLine().split("\\|");
        }

        populationMap.entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    Long firstPopulation =  populationMap.get(c1.getKey())
                            .values()
                            .stream()
                            .mapToLong(i -> i)
                            .sum();

                    Long secondPopulation = populationMap.get(c2.getKey())
                            .values()
                            .stream()
                            .mapToLong(i -> i)
                            .sum();
                    return secondPopulation.compareTo(firstPopulation);
                })
                .forEach(c -> {
                    System.out.printf("%s (total population: %d)%n",
                            c.getKey(),
                            c.getValue().values().stream().mapToLong(i -> i).sum());
                    c.getValue()
                            .entrySet()
                            .stream()
                            .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                            .forEach(t -> System.out.printf("=>%s: %d%n", t.getKey(), t.getValue()));
                });
    }
}
