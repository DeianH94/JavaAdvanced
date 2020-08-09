package exercises.allCapitals;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\allCapitals\\input.txt";
        String outputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\allCapitals\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new PrintWriter(outputPath))) {
            String line = reader.readLine();

            while (line != null) {
                writer.write(line.toUpperCase());
                writer.newLine();

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
