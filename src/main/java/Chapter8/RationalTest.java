package Chapter8;

public class RationalTest {
    public static void main(String[] args){
        Rational fraction1 = new Rational(5,8);
        Rational fraction2 = new Rational(13,10);

        int[] sum = Rational.divideFractional(fraction1,fraction2);

        //System.out.printf("%d/%d", sum[0],sum[1]);

        System.out.println(fraction1.toStringFloating());
    }
}
