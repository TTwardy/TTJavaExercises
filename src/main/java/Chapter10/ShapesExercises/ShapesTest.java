package Chapter10.ShapesExercises;

public class ShapesTest {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Square square = new Square(15);
        Triangle triangle = new Triangle(5,15);
        Sphere sphere = new Sphere(30);
        Cube cube = new Cube(40);
        Tetrahedron tetrahedron = new Tetrahedron(20);

        Shape[] shapes = new Shape[6];
        shapes[0]= circle;
        shapes[1]= square;
        shapes[2]= triangle;
        shapes[3]= sphere;
        shapes[4]=cube;
        shapes[5]=tetrahedron;

        for(Shape currentShape: shapes){
            System.out.println(currentShape);
        }
    }
}
