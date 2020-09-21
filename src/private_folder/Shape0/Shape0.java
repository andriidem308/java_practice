package private_folder.Shape0;

import java.util.ArrayList;

class Shape {
    private double volume;

    public Shape(double volume){
        this.volume = volume;
    }

    public double getVolume(){
        return volume;
    }
}

class SolidOfRevolution extends Shape{
    private double radius;

    public SolidOfRevolution(double volume, double radius){
        super(volume);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Cylinder extends SolidOfRevolution{
    private double height;

    public Cylinder(double radius, double height){
        super(Math.PI * radius * radius * height, radius);
        this.height = height;
    }
}

class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        super(4 * Math.PI*radius*radius*radius / 3, radius);

    }
}

class Pyramid extends Shape {
    private double s, h;

    public Pyramid(double s, double h){
        super(s * h / 3);
        this.s = s;
        this.h = h;
    }
}

class Box extends Shape {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private double available;

    public Box(double available){
        super(available);
        this.available = available;
    }

    public double getAvailable() {
        return available;
    }

    public boolean AddShape(Shape newShape){
        if (available < newShape.getVolume()){
            return false;
        }
        else {
            available -= newShape.getVolume();
            shapes.add(newShape);
            return true;
        }
    }
}

public class Shape0 {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5, 2);
        Ball ball = new Ball(4);
        Ball ball2 = new Ball(5);
        Pyramid pyramid = new Pyramid(4, 5);

        Box box = new Box(500);
        System.out.println(box.AddShape(cylinder));
        System.out.println(box.AddShape(ball));
        System.out.println(box.AddShape(pyramid));
        System.out.println(box.AddShape(ball2));

        System.out.println(box.getAvailable());
    }
}
