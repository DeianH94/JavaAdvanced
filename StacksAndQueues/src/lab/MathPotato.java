package lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int numOfTosses = Integer.parseInt(scanner.nextLine());
        Deque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }

        int cycles = 0;
        while (queue.size() > 1) {
            for (int i = 1; i < numOfTosses; i++) {
                queue.offer(queue.poll());
            }

            cycles++;
            if (isComposite(cycles) || cycles == 1) {
                System.out.println("Removed " + queue.poll());
            } else {
                System.out.println("Prime " + queue.peek());
            }
        }

        System.out.println("Last is " + queue.poll());
    }

    public static boolean isComposite(int n) {
        if (n < 3) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return true;
            }
        }

        return false;
    }
}
