package advJava.classroom.File_write;

import java.io.*;
import java.util.Scanner;

public class File_write {
    public static void main(String args[]) {
        String text = new String(); // to read user input
        Scanner s = new Scanner(System.in);
        FileOutputStream fout;
        FileInputStream fin;
        byte[] array;

        try {
            File fobj = new File("E:\\coding\\codes\\vscode.Java\\advJava\\classroom\\File_write\\File_Write.txt");

            if (fobj.exists())
                System.out.println("File already exists.");

            if (fobj.createNewFile())
                System.out.println("New File is created -> " + fobj.getName());

            fout = new FileOutputStream(fobj, true);

            System.out.println("Writing to file....");

            System.out.print("Enter a message : ");
            text = s.nextLine() + "\n";

            fout.write(text.getBytes());

            System.out.println("Reading from file....");

            fin = new FileInputStream(fobj);

            System.out.println("Available bytes in the file : " + fin.available());

            array = new byte[100];
            // Read byte from the input stream
            fin.read(array);

            String str = new String(array);
            System.out.println("Data read from the file : \n" + str);

            fin.close();
            fout.close();
            s.close();

        } catch (Exception e) {
            System.out.println("An error occurred." + e);
        }

    }
}