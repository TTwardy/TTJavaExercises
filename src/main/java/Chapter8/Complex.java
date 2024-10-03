package Chapter8;

public class Complex {
    private double realPart;
    private double imaginaryPart;
    private final double i = Math.sqrt(-1);

    Complex(double realPart, double imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    Complex(){
        this.realPart = 0;
        this.imaginaryPart = 0;
    }

    public void addNumbers( Complex secondComplex){
        System.out.printf("%.2f+%.2fi\n",realPart+ secondComplex.realPart, imaginaryPart + secondComplex.imaginaryPart);
    }

    public void subtractNumbers( Complex secondComplex){
        System.out.printf("%.2f+%.2fi\n",realPart - secondComplex.realPart, imaginaryPart - secondComplex.imaginaryPart);
    }

//    public void addNumbers(Complex firstComplex, Complex secondComplex){
//        System.out.printf("%f+%f+%f",firstComplex.realPart+ secondComplex.realPart, firstComplex.imaginaryPart + secondComplex.imaginaryPart,i);
//    }
}
