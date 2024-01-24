package advJava.lab.TW5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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