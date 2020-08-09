package exercises.getFolderSize;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\getFolderSize\\Exercises Resources");

        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            int totalSize = 0;
            for (File f : files) {
                if (!f.isDirectory()) {
                    totalSize += f.length();
                }
            }

            System.out.println("Folder size: " + totalSize);
        }
    }
}
