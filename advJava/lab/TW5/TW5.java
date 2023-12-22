package advJava.lab.TW5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// public class TW5 {

//     public static void main(String[] args) {
//         String inputFilePath = "advJava\\lab\\TW5\\input.txt";
//         String outputFilePath = "advJava\\lab\\TW5\\output.txt";

//         try {
//             // Read the text document using Java streams
//             long lineCount = Files.lines(Paths.get(inputFilePath)).count();
//             long wordCount = Files.lines(Paths.get(inputFilePath))
//                     .flatMap(line -> Stream.of(line.split("\\s+")))
//                     .filter(word -> !word.isEmpty())
//                     .count();

//             // Display the results
//             System.out.println("Total Lines: " + lineCount);
//             System.out.println("Total Words: " + wordCount);

//             // Export the analysis results to a new file
//             exportResults(outputFilePath, lineCount, wordCount);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private static void exportResults(String outputFilePath, long lineCount, long wordCount) {
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
//             writer.write("Total Lines: " + lineCount + "\n");
//             writer.write("Total Words: " + wordCount + "\n");
//             System.out.println("Analysis results exported to: " + outputFilePath);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }

public class TW5 {
    public static void main(String[] args) throws IOException {
        int space = 1;
        int newline = 1;

        File file = new File("advJava\\lab\\TW5\\input.txt");
        File output = new File("advJava\\lab\\TW5\\output.txt");

        FileReader file1 = new FileReader(file);
        FileWriter file2 = new FileWriter(output);

        int ch = file1.read();
        if (ch == -1) {
            space = 0;
            newline = 0;
        }

        while (ch != -1) {
            if (ch == 32) {
                space += 1;
            } else if (ch == 10) {
                newline += 1;
                space += 1;
            }
            ch = file1.read();
        }

        String str = new String("No. of words: " + space + "\n" + "No. of Lines: " + newline);
        System.out.println(str);

        file2.write(str);
        file2.flush();

        file1.close();
        file2.close();
    }
}