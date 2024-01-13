package advJava.project;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelEncryptionDecryptionTool {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public static void main(String[] args) {
        String originalData = "Hello, World! This is some data to encrypt and decrypt.";

        // Generate a random secret key
        SecretKey secretKey = generateSecretKey();

        // Convert the secret key to a base64-encoded string for demonstration purposes
        String base64Key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("Secret Key: " + base64Key);

        // Create an ExecutorService with a fixed thread pool size
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Perform encryption
        String encryptedData = encrypt(originalData, secretKey);

        // Perform decryption using the encrypted data
        executorService.submit(() -> decryptAndPrint(encryptedData, secretKey));

        // Shutdown the ExecutorService
        executorService.shutdown();
    }

    private static SecretKey generateSecretKey() {
        String keyString = "MySecretKey12345";
        byte[] keyBytes = keyString.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(keyBytes, ALGORITHM);
    }

    private static String encrypt(String data, SecretKey secretKey) {
        try {
            Cipher encryptCipher = Cipher.getInstance(TRANSFORMATION);
            encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = encryptCipher.doFinal(data.getBytes(StandardCharsets.UTF_8));

            // Encode the encrypted data to base64 before returning
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void decryptAndPrint(String encryptedData, SecretKey secretKey) {
        try {
            // Decode the base64 string before decryption
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);

            Cipher decryptCipher = Cipher.getInstance(TRANSFORMATION);
            decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = decryptCipher.doFinal(encryptedBytes);

            String originalData = new String(decryptedData, StandardCharsets.UTF_8);
            System.out.println("Decrypted Data: " + originalData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
