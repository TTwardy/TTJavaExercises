package Chapter8;

public class HugeIntegerTest {
    public static void main(String[] args){
        HugeInteger firstInt = new HugeInteger();
        HugeInteger secondtInt = new HugeInteger();

        firstInt.parse("55555555");
        secondtInt.parse("55555556");

//        System.out.print(secondtInt);
//        System.out.println();
//        HugeInteger thirdHInt = new HugeInteger();
//        thirdHInt = thirdHInt.subtract(firstInt,secondtInt);
//        System.out.println(thirdHInt.toString());

        firstInt.isGreaterThan(secondtInt);
    }
}
