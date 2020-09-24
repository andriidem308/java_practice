package classwork_2;

import java.util.ArrayList;
import java.util.Scanner;

class BiquadraticEquation {
    private double a, b, c;

    public BiquadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void SolveEquation(){
        double d = b * b - 4 * a * c;

        if (d < 0){
            System.out.println("No roots");
        }
        else if (d == 0) {
            double y1 = -b / 2 / a;
            if (y1 < 0) {
                System.out.println("No roots");
            }
            else if (y1 == 0) {
                System.out.println("Just one root: 0");
            }
            else {
                double x1 = Math.sqrt(y1);
                double x2 = -x1;

                System.out.println("Roots: " + x1 + ", " + x2);
            }
        } else {
            double y1 = (-b + Math.sqrt(d))/(2*a);
            double y2 = (-b - Math.sqrt(d))/(2*a);

            ArrayList<Double> roots = new ArrayList<>();

            if (y1 == 0 && y2 == 0) {
                roots.add(0.0);
            } else {
                if (y1 == 0) {
                    roots.add(0.0);
                }
                else if (y1 > 0) {
                    double x1 = Math.sqrt(y1);
                    double x2 = -x1;

                    roots.add(x1);
                    roots.add(x2);
                }

                if (y2 == 0) {
                    roots.add(0.0);
                }
                else if (y2 > 0) {
                    double x1 = Math.sqrt(y2);
                    double x2 = -x1;

                    roots.add(x1);
                    roots.add(x2);
                }
            }

            if (roots.size() == 0) {
                System.out.println("No roots");
            } else {
                System.out.print("Roots: ");
                for (Double root : roots) {
                    System.out.print(root + ", ");
                }
                System.out.println();
            }
        }
    }
}

public class task_3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a, b, c;
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        BiquadraticEquation bieq = new BiquadraticEquation(a, b, c);
        bieq.SolveEquation();

    }
}
