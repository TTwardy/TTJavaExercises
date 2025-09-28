package Chapter15.CaesarCipher;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static Chapter15.CaesarCipher.CipherLogic.*;

public class GUI {
    static JButton encrypt = new JButton("Encrypt");
    static JButton decrypt = new JButton("Decrypt");
    static JTextField inputFile = new JTextField("CipherInput.txt",15);
    static JTextField outputFile = new JTextField("CipherFile.txt",15);
    static JTextField key = new JTextField(15);
    static JFrame frame = new JFrame("GUI with Labels");

    public static void runGui() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels and text fields
        JLabel label1 = new JLabel("Input File:");
        JLabel label2 = new JLabel("Output File:");
        JLabel label3 = new JLabel("Key:");




        // Row 0
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(label1, gbc);
        gbc.gridx = 1;
        frame.add(inputFile, gbc);

        // Row 1
        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(label2, gbc);
        gbc.gridx = 1;
        frame.add(outputFile, gbc);

        // Row 2
        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(label3, gbc);
        gbc.gridx = 1;
        frame.add(key, gbc);

        // Row 3 - buttons
        gbc.gridx = 0; gbc.gridy = 3;
        frame.add(encrypt, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        frame.add(decrypt, gbc);

        addButtonActionListeners();
        frame.setVisible(true);
    }

    protected static void addButtonActionListeners(){
        encrypt.addActionListener(e ->{
            try {
                if (isCipherKeyValid()) {
                    String encryptedText = encryptText(readFile(inputFile.getText()), readCipherKey());
                    saveFile(encryptedText, outputFile.getText());
                    JOptionPane.showMessageDialog(null, "Text encrypted");
                    frame.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid cipher key");
                }
            } catch (IOException | CipherKeyException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                throw new RuntimeException(ex);
            }
        });
        decrypt.addActionListener(e ->{
            try{
                if (isCipherKeyValid()){
                    String decryptedText = decryptText(readFile(inputFile.getText()), readCipherKey());
                    saveFile(decryptedText, outputFile.getText());
                    JOptionPane.showMessageDialog(null, "Text decrypted");
                    frame.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid cipher key");
                }
            } catch (IOException | CipherKeyException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                throw new RuntimeException(ex);
            }

        });
    }
    protected static int readCipherKey(){
        return Integer.parseInt(key.getText());
    }
    protected static boolean isCipherKeyValid(){
        try{
            Integer.parseInt(key.getText());
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
