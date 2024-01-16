package advJava.classroom;

import java.io.*;

public class FileDir {
    public static void main(String[] args) {
        String dirname = "E:\\coding\\codes\\vscode.Java\\advJava\\classroom";
        File dir = new File(dirname);

        if (dir.isDirectory()) {
            System.out.println("Directory of : " + dirname);
            
            File files[] = dir.listFiles();

            for (File file : files) {
                System.out.println(file.getName());
                System.out.println("\t- Can Write \t: \t" + file.canWrite());
                System.out.println("\t- Is Hidden \t: \t" + file.isHidden());
                System.out.println("\t- Length \t: \t" + file.length() + " bytes");
                System.out.println();
            }
        } else
            System.out.println("Not a directory");
    }
}