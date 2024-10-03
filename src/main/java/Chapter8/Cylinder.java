package Chapter8;

public class Cylinder {
    double radius = 1;
    double height = 1;

    public Cylinder (double radius, double height){
        this.radius = radius;
        this.height = height;
    }
    public Cylinder(){    }

    public double getRadius(){
        return radius;
    }
    public double getHeight(){
        return height;
    }
    public  void setRadius(double radius){
        if (radius>0){
            this.radius=radius;
        }
        else {
            System.out.println("negative number");
        }

    }
    public  void setHeight(double height){
        if (height>0){
            this.height=height;
        }
        else {
            System.out.println("negative number");
            System.exit(0);
        }

    }
    public double calculateVolume(){
        //System.out.println("Radius: "+radius+"Height: "+height);
        return Math.PI*Math.pow(radius,2)*height;
    }
}
