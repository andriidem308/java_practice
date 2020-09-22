package topic_5_arrays;

import java.util.ArrayList;
import java.util.Scanner;

class Point {
    private double x, y, z;

    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(){
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public double getDistance(Point other){
        return Math.sqrt(Math.pow(other.x - this.x, 2)
                + Math.pow(other.y - this.y, 2)
                + Math.pow(other.z - this.z, 2));
    }

    public void printPoint(){
        System.out.printf("(%f, %f, %f)\n", this.x, this.y, this.z);
    }

    public void copy(Point other){
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }

    public Point getCopy(){
        return new Point(this.x, this.y, this.z);
    }
}

public class task_5_4 {
    public static Point scanPoint(String[] str_xyz){
        double x = Integer.parseInt(str_xyz[0]);
        double y = Integer.parseInt(str_xyz[1]);
        double z = Integer.parseInt(str_xyz[2]);

        return new Point(x, y, z);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point main_point = scanPoint(scanner.nextLine().split(" ")) ;
        ArrayList<Point> points = new ArrayList<>();

        while (true) {
            try {
                Point new_point = scanPoint(scanner.nextLine().split(" "));
                points.add(new_point);
            } catch (NumberFormatException nfe) {
                break;
            }
        }

        double max_distance = 0.0;
        Point max_point = main_point.getCopy();

        for (Point point : points) {
            double tmp_distance = main_point.getDistance(point);

            if (tmp_distance > max_distance){
                max_distance = tmp_distance;
                max_point.copy(point);
            }
        }

        System.out.printf("Maximal distance %f between main_point and point: \n", max_distance);
        max_point.printPoint();
    }
}
