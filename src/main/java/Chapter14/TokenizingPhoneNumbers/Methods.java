package Chapter14.TokenizingPhoneNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods {
    StringBuilder concatenatedNumber = new StringBuilder();
    List<String> tokenizedPhoneNumber = new ArrayList<>();

    protected String tokenizePhoneNumber (String phoneNumber){
        concatenatedNumber = new StringBuilder();
        tokenizedPhoneNumber = new ArrayList<>();
        Collections.addAll(tokenizedPhoneNumber,phoneNumber.split("\\(|\\) |-(?=\\d)"));
        tokenizedPhoneNumber.remove(0);
        for(String string : tokenizedPhoneNumber){
            concatenatedNumber.append(string);
        }
        return concatenatedNumber.toString();
    }
    protected String getAreaCode(String phoneNumber){
        Pattern pattern = Pattern.compile("\\((.+)\\)");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.find()) {
            return matcher.group(0);
        } else {
            return null;
        }
    }

    protected void printTokens(){
        for (String s : tokenizedPhoneNumber) {
            System.out.println(s);
        }
    }
}

