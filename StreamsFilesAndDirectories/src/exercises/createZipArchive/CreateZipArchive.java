package exercises.createZipArchive;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) {
        String firstPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\createZipArchive\\fileOne.txt";
        String secondPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\createZipArchive\\fileTwo.txt";
        String thirdPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\createZipArchive\\fileThree.txt";
        String zipPath = "C:\\Users\\Admin\\IdeaProjects\\JavaAdvanced\\StreamsFilesAndDirectories\\src\\exercises\\createZipArchive\\files.zip";

        try (InputStream firstReader = new FileInputStream(firstPath);
             InputStream secondReader = new FileInputStream(secondPath);
             InputStream thirdReader = new FileInputStream(thirdPath);
             ZipOutputStream zipOutput = new ZipOutputStream(new FileOutputStream(zipPath))) {
            addFileToZip(firstPath, firstReader, zipOutput);
            addFileToZip(secondPath, secondReader, zipOutput);
            addFileToZip(thirdPath, thirdReader, zipOutput);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addFileToZip(String path, InputStream reader, ZipOutputStream zipOutput) throws IOException {
        File srcFile = new File(path);
        zipOutput.putNextEntry(new ZipEntry(srcFile.getName()));
        byte[] buffer = new byte[1024];
        int length = reader.read(buffer);

        while (length > 0) {
            zipOutput.write(buffer, 0, length);
            length = reader.read(buffer);
        }

        zipOutput.closeEntry();
    }
}
