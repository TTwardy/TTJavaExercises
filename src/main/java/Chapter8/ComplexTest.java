package Chapter8;

public class ComplexTest {
    public static void main(String[] args){
        Complex firstNumber = new Complex(100,50);
        Complex secondNumber = new Complex(500.50,111.2334);

        firstNumber.addNumbers(secondNumber);
        firstNumber.subtractNumbers(secondNumber);
    }



}
