package exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> messagesCount = new TreeMap<>();

        String[] messageParams = scanner.nextLine().split("\\s+");
        while (!messageParams[0].equalsIgnoreCase("end")) {
            String ip = messageParams[0].split("=")[1];
            String user = messageParams[2].split("=")[1];
            messagesCount.putIfAbsent(user, new LinkedHashMap<>());
            messagesCount.get(user).putIfAbsent(ip, 0);
            messagesCount.get(user).put(ip, messagesCount.get(user).get(ip) + 1);

            messageParams = scanner.nextLine().split("\\s+");
        }

        for (var user : messagesCount.entrySet()) {
            System.out.println(user.getKey() + ":");
            StringBuilder builder = new StringBuilder();
            for (var ips : user.getValue().entrySet()) {
                builder.append(String.format("%s => %d, ", ips.getKey(), ips.getValue()));
            }

            builder.replace(builder.length() - 2, builder.length() - 1, ".");
            System.out.println(builder.toString());
        }
    }
}
