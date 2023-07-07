import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Test {
    private static final String SECRET_KEY = "mySecretKeyhdgffgfdwertygfdertyh";
    private static final String ENCRYPTION_ALGORITHM = "AES";

    public static void main(String[] args) {
        String unencryptedString = "pujakarmakar";
        String encryptedString = encrypt(unencryptedString);
        System.out.println("Encrypted String: " + encryptedString);
        String decryptedString = decrypt(encryptedString);
        System.out.println("Decrypted String: " + decryptedString);
    }

    public static String encrypt(String unencryptedString) {
        try {
            // Create a secret key
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ENCRYPTION_ALGORITHM);

            // Initialize the cipher
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypt the string
            byte[] encryptedText = cipher.doFinal(unencryptedString.getBytes());

            // Encode the encrypted text using Base64
            String encodedText = Base64.getEncoder().encodeToString(encryptedText);

            return encodedText;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String decrypt(String encryptedString) {
        try {
            // Create a secret key
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ENCRYPTION_ALGORITHM);

            // Initialize the cipher
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Decode the encrypted text from Base64
            byte[] encryptedText = Base64.getDecoder().decode(encryptedString);

            // Decrypt the text
            byte[] decryptedText = cipher.doFinal(encryptedText);

            return new String(decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
