package Chapter10.ShapesExercises;

public class Square extends TwoDimensionalShape{
    double length;


    public Square (double length){
        this.length=length;
    }
    @Override
    public double getArea() {
        return Math.pow(length, 2);
    }
}
