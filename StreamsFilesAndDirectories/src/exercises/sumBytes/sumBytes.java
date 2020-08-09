package exercises.sumBytes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class sumBytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\sumBytes\\input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();

            long sum = 0;
            while (line != null) {
                for (char character : line.toCharArray()) {
                    sum += character;
                }

                line = reader.readLine();
            }

            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
