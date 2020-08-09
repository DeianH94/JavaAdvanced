package exercises;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsData = scanner.nextLine().split(";");
        Map<String, Integer> robots = splitRobotsDataIntoLinkedHashMap(robotsData);

        int[] processTimes = new int[robots.size()];
        String[] time = scanner.nextLine().split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);
        long totalSeconds = hours * 3600 + minutes * 60 + seconds;

        Deque<String> products = new ArrayDeque<>();
        String line = scanner.nextLine();

        while (!line.equalsIgnoreCase("end")) {
            products.add(line);
            line = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            totalSeconds++;
            String currentProduct = products.poll();

            decreaseProcessTime(processTimes);

            if (!assignJob(robots, processTimes, currentProduct, totalSeconds)) {
                products.offer(currentProduct);
            }
        }
    }

    private static void decreaseProcessTime(int[] processTimes) {
        for (int i = 0; i < processTimes.length; i++) {
            if (processTimes[i] > 0) {
                --processTimes[i];
            }
        }
    }

    private static boolean assignJob(Map<String, Integer> robots, int[] processTimes, String currentProduct, long totalSeconds) {
        for (int i = 0; i < processTimes.length; i++) {
            if (processTimes[i] == 0) {
                int count = 0;
                for (var entry : robots.entrySet()) {
                    if (count == i) {
                        processTimes[i] = entry.getValue();
                        logJobAssigned(entry.getKey(), currentProduct, totalSeconds);
                        return true;
                    }

                    count++;
                }
            }
        }

        return false;
    }

    private static void logJobAssigned(String name, String product, long totalSeconds) {
        long hours = (totalSeconds / 3600) % 24;
        long minutes = ((totalSeconds % 3600) / 60) % 60;
        long seconds = totalSeconds % 60;

        System.out.printf("%s - %s [%02d:%02d:%02d]%n", name, product, hours, minutes, seconds);
    }

    private static Map<String, Integer> splitRobotsDataIntoLinkedHashMap(String[] robotsData) {
        Map<String, Integer> robots = new LinkedHashMap<>();

        for (String line : robotsData) {
            int index = line.indexOf("-");
            String name = line.substring(0, index);
            int time = Integer.parseInt(line.substring(index + 1));

            robots.put(name, time);
        }

        return robots;
    }
}
