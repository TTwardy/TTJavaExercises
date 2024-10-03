package Chapter8;

public class HugeInteger {
    int [] hInteger = new int[40];

    public void parse (String number){
        boolean isNegative = false;
        if (number.charAt(0)=='-'){
            isNegative = true;
            number = number.substring(1);
        }

        for (int i =0; i<number.length(); i++){
            int digit = number.charAt(number.length()-i-1)-'0';
            hInteger[39-i] = digit;
        }

        if (isNegative){
            hInteger[40-number.length()] = hInteger[40-number.length()]*-1;
        }
    }

    public void isEqualTo (HugeInteger number){
        boolean isEqual;
        int numberAsInt = arrayToInt(number.hInteger);
        if (numberAsInt==arrayToInt(hInteger)){
            isEqual=true;
            System.out.println("numbers are equal");
        }
        else {
            isEqual=false;
            System.out.println("numbers are not equal");
        }
    }

    public void isGreaterThan (HugeInteger number1){
        if (arrayToInt(number1.hInteger)<arrayToInt(hInteger)){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
    public void add(HugeInteger hInteger1){
        int firstNumber = arrayToInt(hInteger1.hInteger);
        int secondNumber = arrayToInt(hInteger);
        int result = firstNumber+ secondNumber;
        System.out.println(result);
    }

    public HugeInteger subtract (HugeInteger number1, HugeInteger number2){
        int firstNumber = arrayToInt(number1.hInteger);
        int secondNumber = arrayToInt(number2.hInteger);
        int result = firstNumber - secondNumber;
        HugeInteger resultHI = new HugeInteger();
        resultHI.parse(String.valueOf(result));
        return resultHI;
    }

    public int arrayToInt (int [] array){
        int result = 0;

        for (int digit: array){
            result = result * 10 + digit;
        }
        return result;
    }
    public int [] removeLeadingZeros(int [] array){
        int countZeros = 0;
        while (countZeros < array.length && array[countZeros] == 0){
            countZeros++;
        }
        int [] newArray = new int[array.length-countZeros];

        for (int i = countZeros; i < array.length; i++) {
        newArray[i-countZeros] = array[i];
        }
        return newArray;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (int number: hInteger){
//            if (number != 0){
//                if (first){
//                    result.append(",");
//                }
                result.append(number);
//                first=false;
//            }
        }
        return result.toString();
    }
}
