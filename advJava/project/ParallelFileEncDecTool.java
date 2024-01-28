package advJava.project;

import java.io.*;
import java.util.Random;

class FileEncDec {
    private Random random = new Random();
    private int key;
    private File inpFile;
    private File encFile;
    private File decFile;

    FileEncDec(File inpFile, File encFile, File decFile) {
        this.inpFile = inpFile;
        this.encFile = encFile;
        this.decFile = decFile;
        key = random.nextInt();
    }

    // Encryption function
    synchronized void encrypt() {
        try {
            System.out.println("Encryption started");

            InputStream fin = new FileInputStream(inpFile);
            OutputStream fout = new FileOutputStream(encFile);

            int c;
            while ((c = fin.read()) != -1) {
                // Encrypt the byte using the encryption key
                int encryptedByte = c + key;

                // Write to the output file
                fout.write(encryptedByte);
            }

            // Closing both files
            fin.close();
            fout.close();

            System.out.println("Encrypting completed....");

            // Sleeping for 1 second
            Thread.sleep(2000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void decrypt() {
        try {
            System.out.println("Waiting for notification from Encrypt Thread.......");

            InputStream fin = new FileInputStream(encFile);
            OutputStream fout = new FileOutputStream(decFile);

            int c;
            while ((c = fin.read()) != -1) {
                // Decrypt the byte using the decryption key
                int decryptedByte = c - key;

                // Write the decrypted byte to the output file
                fout.write(decryptedByte);
            }

            fin.close();
            fout.close();
            
            System.out.println("Decrypting completed....");

            // Sleeping for 1 second
            Thread.sleep(2000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Encrypt extends Thread {
    FileEncDec obj;

    Encrypt(FileEncDec obj) {
        this.obj = obj;
    }

    public void run() {
        obj.encrypt();
    }
}

// Decryption function
class Decrypt extends Thread {
    FileEncDec obj;

    Decrypt(FileEncDec obj) {
        this.obj = obj;
    }

    public void run() {
        obj.decrypt();
    }
}

public class ParallelFileEncDecTool {
    public static void main(String[] args) {
        System.out.println("Starting ParallelFileEncDecTool");

        File inpFile = new File("advJava\\project\\file1.txt");
        File encFile = new File("advJava\\project\\file2.txt");
        File decFile = new File("advJava\\project\\file3.txt");

        FileEncDec obj = new FileEncDec(inpFile, encFile, decFile);

        Encrypt e = new Encrypt(obj);
        Decrypt d = new Decrypt(obj);

        e.start();
        d.start();
    }
}