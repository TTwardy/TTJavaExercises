package Chapter10.ShapesExercises;

public abstract class TwoDimensionalShape extends Shape{

    public abstract double getArea ();

    @Override
    public String toString() {
        return String.format("%s Area:%.2f", getClass().getName(),getArea());
    }
}
