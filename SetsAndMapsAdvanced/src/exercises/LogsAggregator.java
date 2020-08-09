package exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> logs = new TreeMap<>();
        int numOfLogs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLogs; i++) {
            String[] logData = scanner.nextLine().split("\\s+");
            String ip = logData[0];
            String user = logData[1];
            int duration = Integer.parseInt(logData[2]);

            logs.putIfAbsent(user, new TreeMap<>());
            logs.get(user).putIfAbsent(ip, 0);
            logs.get(user).put(ip, logs.get(user).get(ip) + duration);
        }

        logs.forEach((key, value) -> {
            int totalDuration = value.values().stream().mapToInt(i -> i).sum();
            String ipAddresses = String.join(", ", value.keySet());
            System.out.printf("%s: %d [%s]%n", key, totalDuration, ipAddresses);
        });
    }
}
