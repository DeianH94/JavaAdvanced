package lab.extractIntegers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String inputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\lab\\extractIntegers\\input.txt";
        String outputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\lab\\extractIntegers\\output.txt";

        Scanner reader = new Scanner(new FileInputStream(inputPath));
        PrintWriter out = new PrintWriter(new FileOutputStream(outputPath));

        while (reader.hasNext()) {
            if (reader.hasNextInt()) {
                out.println(reader.nextInt());
            }

            reader.next();
        }

        out.close();
    }
}
