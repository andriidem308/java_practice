package classwork_1;

import java.util.Scanner;

public class task_1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a, b;
        System.out.print("Enter first number: ");
        a = scanner.nextInt();
        System.out.print("Enter second number: ");
        b = scanner.nextInt();

        int digits_str;
        int digits_log;
        double harm_mean;

        // *** String-method ***
        digits_str = String.valueOf(Math.abs(a)).length();

        // *** Logarithmic-method ***
        if (b == 0) {
            digits_log = 1;
        } else {
            digits_log = (int) Math.ceil(Math.log10(Math.abs(b) + 0.5));
        }

        harm_mean = 2 / (1.0/a + 1.0/b);

        System.out.printf("\nLogarithmic-method, number %d: %d", b, digits_log);
        System.out.printf("\nString-method, number %d: %d", a, digits_str);

        System.out.printf("\nHarmonic mean: %f", harm_mean);


    }
}
