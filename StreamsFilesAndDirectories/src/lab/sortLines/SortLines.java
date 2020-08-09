package lab.sortLines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) {
        Path inPath = Paths.get("C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\lab\\sortLines\\input.txt");
        Path outPath = Paths.get("C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\lab\\sortLines\\output.txt");

        List<String> lines;
        try {
            lines = Files.readAllLines(inPath);
            lines = lines.stream().filter(l -> !l.isBlank()).collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(outPath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
