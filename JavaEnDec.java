import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import java.awt.Color;
// import javax.swing.UIManager;

public class JavaEnDec extends JFrame {

    private JPanel contentPane;
    private JTextField inputFieldEn;
    private JTextField outputTextFieldEn;
    private JTextField inputFieldDe;
    private JTextField outputTextFieldDe;

    // Backend variables
    // private static final String UNICODE_FORMAT = "UTF8";
    // public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    // private KeySpec ks;
    // private SecretKeyFactory skf;
    // private static Cipher cipher;
    // byte[] arrayBytes;
    // private String myEncryptionKey;
    // private String myEncryptionScheme;
    // static SecretKey key;
    private static final String SECRET_KEY = "mySecretKeyhdgffgfdwertygfdertyh";
    private static final String ENCRYPTION_ALGORITHM = "AES";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JavaEnDec frame = new JavaEnDec();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * 
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeySpecException
     */
    public JavaEnDec() throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeySpecException {

        // backend assign
        // myEncryptionKey = "abcd1234efgh5678ijkl9012mnop3456qrst7890uvwx1234yz56";
        // myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        // arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        // ks = new DESedeKeySpec(arrayBytes);
        // skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        // cipher = Cipher.getInstance(myEncryptionScheme);
        // key = skf.generateSecret(ks);

        /////// frontend components ------

        setTitle("Encryption-Deryption Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(new Color(47, 79, 79));
        tabbedPane.setBounds(10, 0, 411, 254);
        contentPane.add(tabbedPane);

        JPanel panelEn = new JPanel();
        // panelEn.setBackground(new Color(255, 160, 122));
        tabbedPane.addTab("Encryption", null, panelEn, null);
        panelEn.setLayout(null);

        JPanel panelDe = new JPanel();
        // panelDe.setBackground(new Color(143, 188, 143));
        tabbedPane.addTab("Deryption", null, panelDe, null);

        // Decryption Components

        JLabel inputTextDe = new JLabel("Input :");
        inputTextDe.setBounds(68, 58, 61, 16);
        inputTextDe.setVerticalAlignment(SwingConstants.TOP);
        panelDe.add(inputTextDe);

        inputFieldDe = new JTextField();
        inputFieldDe.setBounds(144, 53, 210, 26);
        panelDe.add(inputFieldDe);

        JLabel outputTxtDe = new JLabel("Output :");
        outputTxtDe.setBounds(68, 86, 61, 16);
        panelDe.add(outputTxtDe);

        outputTextFieldDe = new JTextField();
        outputTextFieldDe.setBounds(144, 81, 210, 26);
        panelDe.add(outputTextFieldDe);
        outputTextFieldDe.setColumns(10);
        outputTextFieldDe.setEditable(false);

        JButton submitButtonDe = new JButton("Submit");
        submitButtonDe.setBounds(78, 125, 117, 29);
        panelDe.add(submitButtonDe);
        panelDe.setLayout(null);

        JButton copyButtonDe = new JButton("Copy code");
        copyButtonDe.setBounds(209, 125, 117, 29);
        panelDe.add(copyButtonDe);

        // Encryption Components

        JLabel lblNewLabel = new JLabel("Input :");
        lblNewLabel.setBounds(68, 58, 61, 16);
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        panelEn.add(lblNewLabel);

        inputFieldEn = new JTextField();
        inputFieldEn.setBounds(144, 53, 210, 26);
        panelEn.add(inputFieldEn);
        inputFieldEn.setColumns(10);

        JLabel outputTextEn = new JLabel("Output :");
        outputTextEn.setBounds(68, 86, 61, 16);
        panelEn.add(outputTextEn);

        outputTextFieldEn = new JTextField();
        outputTextFieldEn.setBounds(144, 81, 210, 26);
        panelEn.add(outputTextFieldEn);
        outputTextFieldEn.setEditable(false);
        outputTextFieldEn.setColumns(10);

        JButton submitButtonEn = new JButton("Submit");
        submitButtonEn.setBounds(149, 121, 117, 29);
        panelEn.add(submitButtonEn);
        // panelEn.setLayout(null);

        //////// Frontend componets ----

        // event listners

        submitButtonEn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputText = inputFieldEn.getText();
                String encryptedText;
                    encryptedText = encrypt(inputText);
                    outputTextFieldEn.setText(encryptedText);
                
                // outputTextFieldEn.setText(encryptedText);
            }
        });

        // submitButtonDe.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // String inputText = inputFieldDe.getText();
        // String decryptedText = decrypt(inputText);
        // outputTextFieldDe.setText(decryptedText);
        // }
        // });

    }

    // public String encrypt(String unencryptedString) {
    // String encryptedString = null;
    // try {
    // cipher.init(Cipher.ENCRYPT_MODE, key);
    // byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
    // byte[] encryptedText = cipher.doFinal(plainText);
    // byte[] encodedBytes = Base64.getEncoder().encode(encryptedText);
    // encryptedString = new String(Base64.getDecoder().decode(encodedBytes));
    // System.out.println( encryptedString);
    // } catch (Exception e) {
    // // ignore
    // }
    // return encryptedString;
    // }

    public String encrypt(String unencryptedString){
        try {
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ENCRYPTION_ALGORITHM);// Create a secret key
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);// Initialize the cipher
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedText = cipher.doFinal(unencryptedString.getBytes());// Encrypt the string
            String encodedText = Base64.getEncoder().encodeToString(encryptedText);// Encode the encrypted text using Base64
            return encodedText;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public String decrypt(String encryptedString) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ENCRYPTION_ALGORITHM);
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] encryptedText = Base64.getDecoder().decode(encryptedString);// Decode the encrypted text from Base64
            byte[] decryptedText = cipher.doFinal(encryptedText);
            return new String(decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

