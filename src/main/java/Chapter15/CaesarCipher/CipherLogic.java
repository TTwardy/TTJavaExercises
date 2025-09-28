package Chapter15.CaesarCipher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class CipherLogic {
    public static String readFile(String fileName) throws IOException {
        try (Scanner input = new Scanner(Paths.get(fileName))) {
            return input.next();
        }
    }

    protected static String encryptText(String fileText, int cipherKey) throws CipherKeyException {
        StringBuilder encryptedWord = new StringBuilder("");

        for (int i = 0; i < fileText.length(); i++) {
            char character = fileText.charAt(i);
            if ((int) character + cipherKey < 122){
                encryptedWord.append((char) ((int) character + cipherKey - 57));
            }
            else {
                throw new CipherKeyException("Invalid Cipher Key exception");
            }
        }
        return encryptedWord.toString();
    }

    protected static void saveFile(String text, String filename) throws FileNotFoundException {
        try (Formatter formatter = new Formatter(filename)) {
            formatter.format("%s", text);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    protected static String decryptText(String fileText, int cipherKey) throws CipherKeyException {
        StringBuilder decryptedWord = new StringBuilder("");

        for (int i = 0; i < fileText.length(); i++) {
            char character = fileText.charAt(i);
            if ((int) character - cipherKey < 97 && (int) character - cipherKey > 90) {
                decryptedWord.append((char) ((int) character - cipherKey - 6));
            } else if ((int) character - cipherKey < 65 && (int) character - cipherKey > 8) {
                decryptedWord.append((char) ((int) character - cipherKey + 57));
            } else {
                throw new CipherKeyException("Invalid Cipher Key exception");
            }
        }
        return decryptedWord.toString();
    }
}
