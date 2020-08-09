package lab.serializeCustomObject;

import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) {
        Cube cube = new Cube("green", 15.3, 12.4, 3);
        String path = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\lab\\serializeCustomObject\\save.txt";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
