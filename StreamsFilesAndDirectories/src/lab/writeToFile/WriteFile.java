package lab.writeToFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteFile {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\lab\\writeToFile\\input.txt";
        String outputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\lab\\writeToFile\\output.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {
            int oneByte;
            while ((oneByte = in.read()) >= 0) {
                if (!symbols.contains((char)oneByte)) {
                    out.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
