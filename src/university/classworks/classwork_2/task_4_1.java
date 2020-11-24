package classwork_2;

import java.util.Scanner;

public class task_4_1 {
    public static boolean isNatural(int number){
        return number >= 1;
    }

    public static int factorial(int number){
        if (number == 1) return 1;
        return number * factorial(number - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        if (isNatural(n)){
            System.out.println("n is natural!");
            int fact_rec, fact_for;

            fact_rec = factorial(n);
            fact_for = 1;

            for (int m = 1; m <= n; m++){
                fact_for *= m;
            }

            System.out.println("Recursive factorial: " + fact_rec);
            System.out.println("Built-in-Loop factorial: " + fact_for);

        } else {
            System.out.println("n is not natural. it is impossible to calculate its factorial!");
        }

    }
}
