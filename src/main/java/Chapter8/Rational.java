package Chapter8;

public class Rational {
    private final int numerator;
    private final int denominator;

    public Rational (int numerator, int denominator){
        int gcd = gcd(numerator, denominator);
        this.numerator=numerator / gcd;
        this.denominator=denominator / gcd;
    }

    public static int[] addFractional(Rational rational1, Rational rational2){
        int commonDenominator = rational1.denominator * rational2.denominator;
        int newNum1 = rational1.numerator * rational2.denominator;
        int newNum2 = rational2.numerator * rational1.denominator;

        int sum = newNum1 + newNum2;
        int gcd = gcd(sum, commonDenominator);

        return new int[] { sum / gcd, commonDenominator / gcd };
    }

    public static int[] subtractFractional(Rational rational1, Rational rational2){
        int commonDenominator = rational1.denominator * rational2.denominator;
        int newNum1 = rational1.numerator * rational2.denominator;
        int newNum2 = rational2.numerator * rational1.denominator;

        int difference = newNum1 - newNum2;
        int gcd = gcd(Math.abs(difference), commonDenominator);

        return new int[] { difference / gcd, commonDenominator / gcd };
    }

    public static int[] multiplyFractional(Rational rational1, Rational rational2){
        int top = rational1.numerator * rational2.numerator;
        int bottom = rational2.denominator * rational1.denominator;

        return new int[] { top, bottom};
    }

    public static int[] divideFractional(Rational rational1, Rational rational2){
        int top = rational1.numerator * rational2.denominator;
        int bottom = rational1.denominator * rational2.numerator;

        return new int[] { top, bottom};
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String toString (){
        return String.format("%d/%d",numerator, denominator);
    }
    public String toStringFloating (){
        return String.format("%f", (float) numerator /denominator);
    }
}
