package private_folder.Shape1;

abstract class Shape {
    public abstract double getVolume();
}

abstract class SolidOfRevolution extends Shape {
    protected double radius;

    public SolidOfRevolution(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }
}

class Cylinder extends SolidOfRevolution {
    private double height;

    public Cylinder(double radius, double height){
        super(radius);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }
}

class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        super(radius);
    }

    @Override
    public double getVolume(){
        return 4 * Math.PI * Math.pow(radius, 3) / 3;
    }
}

class Pyramid extends Shape {
    private double s, h;

    public Pyramid(double s, double h){
        this.s = s;
        this.h = h;
    }

    @Override
    public double getVolume() {
        return s * h / 3;
    }
}

public class Shape1 {
    public static void main(String[] args) {
        Ball ball = new Ball(4);
        System.out.println(ball.getVolume());
    }
}
