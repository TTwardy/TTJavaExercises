package Chapter10.ShapesExercises;

import Chapter10.ShapesExercises.ThreeDimensionalShape;

public class Cube extends ThreeDimensionalShape {
    double sideLength;

    public Cube (double sideLength){
        this.sideLength=sideLength;
    }

    @Override
    public double getVolume() {
        return Math.pow(sideLength,3);
    }
}
