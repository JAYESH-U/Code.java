package advJava.project;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptionDecryptionGUI extends JFrame {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    private JTextArea inputTextArea;
    private JTextArea outputTextArea;

    public EncryptionDecryptionGUI() {
        super("Parallel Encryption/Decryption Tool");

        // Generate a random secret key
        SecretKey secretKey = generateSecretKey();

        // Convert the secret key to a base64-encoded string for demonstration purposes
        String base64Key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("Secret Key: " + base64Key);

        // Create input and output JTextAreas
        inputTextArea = new JTextArea(5, 20);
        outputTextArea = new JTextArea(5, 20);
        outputTextArea.setEditable(false);

        // Create buttons
        JButton encryptButton = new JButton("Encrypt");
        JButton decryptButton = new JButton("Decrypt");

        // Add action listeners to buttons
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputTextArea.getText();
                String encryptedData = encrypt(inputText, secretKey);
                outputTextArea.setText("Encrypted Data:\n" + encryptedData);
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String encryptedData = inputTextArea.getText();
                String decryptedData = decrypt(encryptedData, secretKey);
                outputTextArea.setText("Decrypted Data:\n" + decryptedData);
            }
        });

        // Create layout using GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add components to the frame
        add(new JScrollPane(inputTextArea), gbc);

        gbc.gridy++;
        add(new JScrollPane(outputTextArea), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);
        add(buttonPanel, gbc);

        // Set JFrame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
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
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String decrypt(String encryptedData, SecretKey secretKey) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
            Cipher decryptCipher = Cipher.getInstance(TRANSFORMATION);
            decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = decryptCipher.doFinal(encryptedBytes);
            return new String(decryptedData, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EncryptionDecryptionGUI());
    }
}
