package exercises;

import java.util.*;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numOfOperations = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numOfPushes = numOfOperations[0];
        int numOfPops = numOfOperations[1];
        int numToFind = numOfOperations[2];

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numOfPushes; i++) {
            queue.offer(sequence[i]);
        }

        for (int i = 0; i < numOfPops; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(numToFind)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
