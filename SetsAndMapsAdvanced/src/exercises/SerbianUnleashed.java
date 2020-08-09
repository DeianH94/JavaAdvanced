package exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        final String regex = "(?<singerName>[A-Za-z ]+)\\s@(?<venue>[A-Za-z ]+)\\s(?<ticketPrice>\\d+)\\s(?<ticketCounts>\\d+)";
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> venueMap = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        String venueParams = scanner.nextLine();
        while (!venueParams.equalsIgnoreCase("end")) {
            matcher = pattern.matcher(venueParams);
            if (matcher.find()) {
                String venue = matcher.group("venue");
                String singerName = matcher.group("singerName");
                int ticketPrice = Integer.parseInt(matcher.group("ticketPrice"));
                int ticketCounts = Integer.parseInt(matcher.group("ticketCounts"));

                venueMap.putIfAbsent(venue, new LinkedHashMap<>());
                venueMap.get(venue).putIfAbsent(singerName, 0L);
                venueMap.get(venue).put(singerName, venueMap.get(venue).get(singerName) + (ticketPrice * ticketCounts));
            }

            venueParams = scanner.nextLine();
        }

        venueMap.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue())).forEach(s -> {
                System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue());
            });
        });
    }
}
