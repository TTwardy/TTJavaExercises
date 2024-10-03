package Chapter8;

import Chapter8.Cylinder;

public class CylinderTest {
    public static void main(String[] args){
        Cylinder cylinder = new Cylinder(10,-5);
//        cylinder.setRadius(10);
//        cylinder.setHeight(-5);
        System.out.printf("Radius: %02f%nHeight: %f%n",cylinder.getRadius(), cylinder.getHeight());
        System.out.println(cylinder.calculateVolume());
    }

}
