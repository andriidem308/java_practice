package classwork_2;

import java.beans.Expression;
import java.util.Scanner;

public class task_4_6 {
    public static int factorial(int number){
        int r = 1;
        for (int i = 1; i <= number; i++){
            r *= i;
        }

        return r;
    }

    public static double function(double x, int y){
        return (Math.pow(x, 2*y)) / (2 * factorial(y));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x, eps;
        x = scanner.nextDouble();
        eps = scanner.nextDouble();

        double prev_sum_a = 1000;
        double sum = 0;
        int i = 0;

        while (Math.abs(prev_sum_a - sum) > eps){
            prev_sum_a = sum;
            sum += function(x, i);
            i+=1;
        }

        System.out.println("Sum: " + sum + "\nTerms amount: " + (i+1));
    }
}
