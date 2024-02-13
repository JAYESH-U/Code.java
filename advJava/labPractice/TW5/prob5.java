/*
 * Write a multithreaded Java program that encrypts and decrypts data concurrently, 
 * employing multithreading for parallel processing.
 */

package advJava.labPractice.TW5;

import java.io.*;
import java.util.Random;

class FileEncDec {
    private Random random = new Random();
    private int key;
    private File inpFile;
    private File encFile;
    private File decFile;
    private boolean encryptionComplete = false;

    FileEncDec(File inpFile, File encFile, File decFile) {
        this.inpFile = inpFile;
        this.encFile = encFile;
        this.decFile = decFile;
        key = random.nextInt();
    }

    synchronized void encrypt() {
        try {
            System.out.println("Encryption started");

            InputStream fin = new FileInputStream(inpFile);
            OutputStream fout = new FileOutputStream(encFile);

            int c;
            while ((c = fin.read()) != -1) {
                int encryptedByte = c + key;
                fout.write(encryptedByte);
            }

            fin.close();
            fout.close();

            System.out.println("Encrypting completed....");

            // Set encryptionComplete to true and notify waiting threads
            encryptionComplete = true;
            notify();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    synchronized void decrypt() {
        try {
            // Wait until encryption is complete
            while (!encryptionComplete) {
                wait();
            }

            System.out.println("Decrypting started");

            InputStream fin = new FileInputStream(encFile);
            OutputStream fout = new FileOutputStream(decFile);

            int c;
            while ((c = fin.read()) != -1) {
                int decryptedByte = c - key;
                fout.write(decryptedByte);
            }

            fin.close();
            fout.close();

            System.out.println("Decrypting completed....");
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

class Decrypt extends Thread {
    FileEncDec obj;

    Decrypt(FileEncDec obj) {
        this.obj = obj;
    }

    public void run() {
        obj.decrypt();
    }
}

public class prob5 {
    public static void main(String[] args) {
        System.out.println("Parallel File Encryption Decryption Tool using ITC");

        File inpFile = new File("advJava\\labPractice\\TW5\\file1.txt");
        File encFile = new File("advJava\\labPractice\\TW5\\file2.txt");
        File decFile = new File("advJava\\labPractice\\TW5\\file3.txt");

        FileEncDec obj = new FileEncDec(inpFile, encFile, decFile);

        Encrypt e = new Encrypt(obj);
        Decrypt d = new Decrypt(obj);

        e.start();
        d.start();
    }
}