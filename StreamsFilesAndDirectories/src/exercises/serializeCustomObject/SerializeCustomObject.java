package exercises.serializeCustomObject;

import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\serializeCustomObject\\input.ser";
        String outputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\serializeCustomObject\\course.ser";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputPath));
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputPath))) {
            Course course = (Course) ois.readObject();

            oos.writeObject(course);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
