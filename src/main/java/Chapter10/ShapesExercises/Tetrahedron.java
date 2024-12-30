package Chapter10.ShapesExercises;

public class Tetrahedron extends ThreeDimensionalShape {
    double edge;

    public Tetrahedron (double edge){
        this.edge=edge;
    }

    @Override
    public double getVolume() {
        return (Math.sqrt(2)/12)*Math.pow(edge,3);
    }
}
