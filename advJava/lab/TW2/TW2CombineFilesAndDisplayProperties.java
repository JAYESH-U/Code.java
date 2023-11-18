package advJava.lab.TW2;

import java.io.*;

public class TW2CombineFilesAndDisplayProperties {
    public static void main(String[] args) {
        try {
            // Combine two files into a third file
            combineFiles("advJava\\lab\\TW2\\file1.txt", "advJava\\lab\\TW2\\file2.txt",
                    "advJava\\lab\\TW2\\combinedFile.txt");

            // Display properties of the third file
            displayFileProperties("advJava\\lab\\TW2\\combinedFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Combine two files into a third file
    private static void combineFiles(String inputFile1, String inputFile2, String outputFile) throws IOException {
        try {
            InputStream input1 = new FileInputStream(inputFile1);
            InputStream input2 = new FileInputStream(inputFile2);
            OutputStream output = new FileOutputStream(outputFile);

            // Copy content from file1 to the output file
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input1.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            // Copy content from file2 to the output file
            while ((bytesRead = input2.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            System.out.println("Files combined successfully!");

            input1.close();
            input2.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Display properties of a file
    private static void displayFileProperties(String filePath) {
        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Parent: " + file.getParent());
            System.out.println("File exists: " + file.exists());
            System.out.println("Is Readable: " + file.canRead());
            System.out.println("Is Writable: " + file.canWrite());
            System.out.println("Is a Directory: " + file.isDirectory());
            System.out.println("File Length: " + file.length() + " bytes");
        } else {
            System.out.println("File does not exist.");
        }
    }
}
