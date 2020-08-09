package exercises.mergeTwoFiles;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String firstInputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\mergeTwoFiles\\inputOne.txt";
        String secondInputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\mergeTwoFiles\\inputTwo.txt";
        String outputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\mergeTwoFiles\\output.txt";

        try (BufferedReader firstReader = new BufferedReader(new FileReader(firstInputPath));
             BufferedReader secondReader = new BufferedReader(new FileReader(secondInputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath , true))) {

            String line = firstReader.readLine();
            while (line != null) {
                writer.write(line);
                writer.newLine();
                line = firstReader.readLine();
            }

            line = secondReader.readLine();
            while (line != null) {
                writer.write(line);
                writer.newLine();
                line = secondReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
