package homework_1;

import java.util.Scanner;

public class task_4_5b {
    public static double func(int n, double x){
        if (n==0) return 1;
        if (n==1) return 2*x;

        return 2*x*func(n-1, x) - 2*(n-1)*func(n-2, x);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double x = scanner.nextDouble();

        double result = func(n, x);
        System.out.println("\nResult: " + result);

    }
}
