package exercises.lineNumbers;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\lineNumbers\\inputLineNumbers.txt";
        String outputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\lineNumbers\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new PrintWriter(outputPath))) {
            String line = reader.readLine();

            int lineNumber = 1;
            while (line != null) {
                writer.write(lineNumber + ". " + line);
                writer.newLine();

                lineNumber++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
