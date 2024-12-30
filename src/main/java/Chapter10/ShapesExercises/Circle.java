package Chapter10.ShapesExercises;

import Chapter10.ShapesExercises.TwoDimensionalShape;

public class Circle extends TwoDimensionalShape {
    double radius;

    public Circle(int radius){
        this.radius=radius;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius,2);
    }

}
