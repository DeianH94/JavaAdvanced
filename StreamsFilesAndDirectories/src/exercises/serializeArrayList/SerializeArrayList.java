package exercises.serializeArrayList;

import java.io.*;
import java.util.ArrayList;

public class SerializeArrayList {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\serializeArrayList\\input.ser";
        String outputPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\serializeArrayList\\list.ser";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputPath));
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputPath))) {
            ArrayList<Double> list = (ArrayList<Double>) ois.readObject();
            list.add(5.6);
            list.add(8.2);
            list.add(1.3);

            oos.writeObject(list);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
