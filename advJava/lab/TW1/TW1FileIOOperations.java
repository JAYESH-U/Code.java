package advJava.lab.TW1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class TW1FileIOOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Print characters on the console (one character at a time)");
                System.out.println("2. Print the entire file");
                System.out.println("3. Print contents to another file");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                InputStream input = new FileInputStream("advJava\\lab\\TW1\\input.txt");
                OutputStream output = new FileOutputStream("advJava\\lab\\TW1\\output.txt");

                switch (choice) {
                    case 1:
                        printCharacters(input);
                        break;
                    case 2:
                        String data = printEntireFile(input);
                        System.out.println(data);
                        break;
                    case 3:
                        printToFile(input, output);
                        break;
                    case 4:
                        System.out.println("Exiting the program.");
                        input.close();
                        output.close();
                        sc.close();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (choice != 4);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCharacters(InputStream input) throws IOException {
        System.out.println("\nFile content is: ");
        int charValue = input.read();
        while (charValue != -1) {
            System.out.println((char) charValue);
            charValue = input.read();
        }
        System.out.println();
    }

    private static String printEntireFile(InputStream input) throws IOException {
        byte[] array = new byte[100];
        input.read(array);
        System.out.println("\nFile content is: ");
        String data = new String(array);
        return data;
    }

    private static void printToFile(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[1];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        System.out.println("Contents printed to another file successfully.");
    }
}
