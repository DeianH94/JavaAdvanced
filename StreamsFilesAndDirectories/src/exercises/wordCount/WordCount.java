package exercises.wordCount;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {
        String wordsPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\wordCount\\words.txt";
        String textPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\wordCount\\text.txt";
        String outputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\wordCount\\results.txt";

        try (BufferedReader wordsReader = new BufferedReader(new FileReader(wordsPath));
             BufferedReader textReader = new BufferedReader(new FileReader(textPath));
             BufferedWriter writer = new BufferedWriter(new PrintWriter(outputPath))) {
            Map<String, Integer> wordCountMap = new LinkedHashMap<>();
            List<String> text = new ArrayList<>();
            String line = wordsReader.readLine();
            String[] words = line.split("\\s+");
            for (String word : words) {
                wordCountMap.put(word, 0);
            }

            line = textReader.readLine();

            while (line != null) {
                text.addAll(Arrays.asList(line.split("\\s+")));
                line = textReader.readLine();
            }

            for (var word : wordCountMap.entrySet()) {
                for (int i = 0; i < text.size(); i++) {
                    if (word.getKey().equals(text.get(i))) {
                        word.setValue(word.getValue() + 1);
                    }
                }
            }

            wordCountMap = wordCountMap.entrySet()
                    .stream()
                    .sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));

            for (var word : wordCountMap.entrySet()) {
                writer.write(word.getKey() + " - " + word.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
