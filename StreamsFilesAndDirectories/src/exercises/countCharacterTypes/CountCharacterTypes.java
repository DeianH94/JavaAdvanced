package exercises.countCharacterTypes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) {
        Path inputPath = Paths.get("C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\countCharacterTypes\\input.txt");
        String outputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\countCharacterTypes\\output.txt";

        try (BufferedWriter writer = new BufferedWriter(new PrintWriter(outputPath))) {
            List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
            List<Character> punctuation = Arrays.asList('!', ',', '.', '?');
            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationCount = 0;

            List<String> lines = Files.readAllLines(inputPath);
            for (String line : lines) {
                for (int j = 0; j < line.length(); j++) {
                    char currentChar = line.charAt(j);
                    if (Character.isWhitespace(currentChar)) {
                        continue;
                    } else if (vowels.contains(currentChar)) {
                        vowelsCount++;
                    } else if (punctuation.contains(currentChar)) {
                        punctuationCount++;
                    } else {
                        consonantsCount++;
                    }
                }
            }

            String totalCounts = "Vowels: " + vowelsCount + System.lineSeparator() +
                    "Consonants: " + consonantsCount + System.lineSeparator() +
                    "Punctuation: " + punctuationCount + System.lineSeparator();
            writer.write(totalCounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
