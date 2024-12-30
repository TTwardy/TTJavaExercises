package Chapter10.ShapesExercises;

public abstract class ThreeDimensionalShape  extends Shape{

    public abstract double getVolume();

    @Override
    public String toString() {
        return String.format("%s Area:%.2f", getClass().getName(),getVolume());
    }
}
