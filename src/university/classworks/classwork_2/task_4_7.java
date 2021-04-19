package classwork_2;

import java.util.Scanner;

public class task_4_7 {
    public static double expTailor(double x){
        double eps = 10e-8;
        double result = 1, a = 1;
        int i = 1;

        while (a > eps){
            a *= x / i;
            result += a;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        System.out.println(expTailor(x));
        System.out.println(Math.exp(x));
    }
}
