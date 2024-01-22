package advJava.project;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelFileEncryptionDecryptionTool {

    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // File paths
        String inputFile = "advJava\\project\\file1.txt";
        String encryptedFile = "advJava\\project\\file2.txt";
        String decryptedFile = "advJava\\project\\file3.txt";

        // Shared object for synchronization
        Object lock = new Object();

        // Generate a secret key for encryption/decryption
        SecretKey secretKey = generateSecretKey();

        // Task 1: Encryption
        Runnable encryptTask = () -> {
            try {
                encryptFile(inputFile, encryptedFile, secretKey);
                System.out.println("Encryption complete. Notifying decryption thread.");

                // Notify the decryption thread
                synchronized (lock) {
                    lock.notify();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // Task 2: Decryption
        Runnable decryptTask = () -> {
            try {
                // Wait for encryption to complete before starting decryption
                System.out.println("Decryption thread waiting for notification...");
                synchronized (lock) {
                    lock.wait();
                }

                decryptFile(encryptedFile, decryptedFile, secretKey);
                System.out.println("Decryption complete.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        executor.execute(encryptTask);
        executor.execute(decryptTask);

        executor.shutdown();
    }

    private static SecretKey generateSecretKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }

    private static void encryptFile(String inputFile, String outputFile, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                cos.write(buffer, 0, bytesRead);
            }
        }
    }

    private static void decryptFile(String inputFile, String outputFile, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             CipherInputStream cis = new CipherInputStream(fis, cipher);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = cis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
