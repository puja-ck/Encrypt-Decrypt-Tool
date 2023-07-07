import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;



public class JavaUI extends JFrame {
    JFrame frame;
    // private static final String UNICODE_FORMAT = "UTF8";
    // public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private JTextField inputEnc;
    private JTextField outputEnc;
    private JTextField inputDec;
    private JTextField outputDec;
    private JButton encryptButton;
    private JButton decryptButton;
    private JTabbedPane tabs;
    private JPanel encryptPanel;
    private JPanel decryptPanel;
    private JLabel inputLableEnc;
    private JLabel outputLableEnc;
    private JLabel inputLableDec;
    private JLabel outputLableDec;
    // Class implementation goes here
    public JavaUI() {


        // Set window properties
        frame = new JFrame();
        setTitle("Encrypt-Decrypt Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setSize(400, 200);
        // setLayout(null);

        encryptPanel = new JPanel();
        decryptPanel = new JPanel();

        inputLableEnc = new JLabel("Input:");
        inputLableEnc.setBounds(20, 20, 60, 25);
        encryptPanel.add(inputLableEnc, BorderLayout.NORTH);

        inputEnc = new JTextField();
        inputEnc.setBounds(50, 20, 100, 25);
        encryptPanel.add(inputEnc, BorderLayout.NORTH);

        outputLableEnc = new JLabel("Output:");
        outputLableEnc.setBounds(20, 60, 60, 25);
        encryptPanel.add(outputLableEnc, BorderLayout.CENTER);

        outputEnc = new JTextField();
        outputEnc.setBounds(50, 80, 100, 25);
        outputEnc.setEditable(false);
        encryptPanel.add(outputEnc, BorderLayout.CENTER);

        encryptButton = new JButton("Submit");
        encryptButton.setBounds(50, 100, 100, 30);
        encryptPanel.add(encryptButton, BorderLayout.SOUTH);

///////
        // inputLableDec = new JLabel("Input:");
        // inputLableDec.setBounds(20, 20, 60, 25);
        // decryptPanel.add(inputLableDec);

        // inputDec = new JTextField();
        // inputDec.setBounds(80, 20, 280, 25);
        // decryptPanel.add(inputDec);

        // outputLableDec = new JLabel("Output:");
        // outputLableDec.setBounds(20, 60, 60, 25);
        // decryptPanel.add(outputLableDec);

        // outputDec = new JTextField();
        // outputDec.setBounds(80, 60, 280, 25);
        // outputDec.setEditable(false);
        // decryptPanel.add(outputDec);

        decryptButton = new JButton("Submit");
        decryptButton.setBounds(200, 100, 100, 30);
        decryptPanel.add(decryptButton);



        tabs = new JTabbedPane();
        // tabs.setTabPlacement(JTabbedPane.RIGHT);
        tabs.setBounds(20, 20, 400, 400);
        tabs.addTab("Encrypt", encryptPanel);
        tabs.addTab("Decrypt", decryptPanel);

        frame.add(tabs);
        frame.setSize(400, 400);
        frame.setVisible(true);


        ///////logic
    //     encryptButton.addActionListener(new ActionListener() {
    //         public void actionPerformed(ActionEvent e) {
    //             String inputText = input.getText();
    //             String encryptedText = encrypt(inputText);
    //             output.setText(encryptedText);
    //         }
    //     });

    //     decryptButton.addActionListener(new ActionListener() {
    //         public void actionPerformed(ActionEvent e) {
    //             String inputText = input.getText();
    //             String decryptedText = decrypt(inputText);
    //             output.setText(decryptedText);
    //         }
    //     });

    // }
    // private String encrypt(String input) {
    //     //////logic
    //     String encryptedString = null;
    // try {
    //   cipher.init(Cipher.ENCRYPT_MODE, key);
    //   byte[] plainText = input.getBytes(UNICODE_FORMAT);
    //   byte[] encryptedText = cipher.doFinal(plainText);
    //   encryptedString = new String(Base64.encodeBase64(encryptedText));
    //   System.out.println(CRYPTO.ENCRYPT + "\t\t" + encryptedString);
    // } catch (Exception e) {
    //   // ignore
    // }
    //     return encryptedString; // Placeholder
    // }

    // private String decrypt(String input) {
    //     //////logic
    //     return input; // Placeholder
    // }
    }
    
    public static void main(String[] args) {
        new JavaUI();
    }
}