package Chapter15.telephoneNumbersToWords;

import java.util.Formatter;

public class NumberToWordsProcessor {
    static String[] keypad = {
            "",
            "",
            "ABC",
            "DEF",
            "GHI",
            "JKL",
            "MNO",
            "PRS",
            "TUV",
            "WXY"
    };
    String phoneNumber;

    public NumberToWordsProcessor(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    protected void generateCombinations(int index, String currentWord, Formatter formatter) {
        if (index == phoneNumber.length()) {
            formatter.format("%s%n", currentWord);
            return;
        }
        int digit = Character.getNumericValue((phoneNumber).charAt(index));
        if (digit <= 2) {
            generateCombinations(index + 1, currentWord, formatter);
            return;
        }
        String letters = keypad[digit];

        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            generateCombinations(index + 1, currentWord + letter, formatter);
        }
    }
}
