/*
Write a Java Program to demonstrate the implementation of stream classes in Java. Assume
that an input file named input.txt already exists with few lines of random text. Accept a
filename from the user, this will be the destination file. Write a menu driven program to do
the following:
1) Transfer the contents of the input file to the destination file using the
ByteArrayInputStream /ByteArrayInputStream class
3) Display the contents of the
destination file.
*/

package advJava.labPractice.TW2;

import java.io.*;
import java.util.Scanner;

public class prob2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the output file name: ");
        FileController f1 = new FileController(scn.next());
        int choice = 0;
        while (choice != 3) {
            System.out.println("\nEnter your choice:\n1)Write input file into output\n2)Print the output file\n3)exit");
            choice = scn.nextInt();
            switch (choice) {
                case 1:
                    f1.transfer();
                    break;
                case 2:
                    f1.print();
                    break;
                case 3:
                    System.out.println("Bye!!");
                    break;
                default:
                    System.out.println("Please enter a right choice!!");
            }
        }
        scn.close();
    }
}

class FileController {
    private String filein;
    private String fileout;

    FileController(String filepath) {
        filein = "advJava\\labPractice\\TW2\\input.txt";
        fileout = "advJava\\labPractice\\TW2\\" + filepath;
    }

    void transfer() {
        try (FileInputStream fin = new FileInputStream(filein);
                FileOutputStream fout = new FileOutputStream(fileout)) {

            int len = fin.available();
            byte[] data = new byte[len];

            // read data from file and store in a byte array
            fin.read(data);

            try (ByteArrayInputStream bin = new ByteArrayInputStream(data);
                    ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
                // write the byte array to the output byte array stream
                bout.write(bin.readAllBytes());
                bout.writeTo(fout);

            } catch (IOException ex) {
                System.out.println("Error: " + ex);
            }

        } catch (IOException ex) {
            System.out.println("Error in writing in the output file!!");
        }
    }

    void print() {
        try (FileInputStream fin = new FileInputStream(filein)) {
            
            int len = fin.available();
            byte[] data = new byte[len];

            // read data from file and store in a byte array
            fin.read(data);

            try (ByteArrayInputStream bin = new ByteArrayInputStream(data);
                    ByteArrayOutputStream bout = new ByteArrayOutputStream()) {

                // write the byte array to the output byte array stream
                bout.write(bin.readAllBytes());
                bout.writeTo(System.out);

            } catch (IOException ex) {
                System.out.println("Error: " + ex);
            }
        } catch (IOException ex) {
            System.out.println("error in writing on to System.out ");
        }
    }
}
