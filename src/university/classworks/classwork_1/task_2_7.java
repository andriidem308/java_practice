package classwork_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task_2_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            long x = scanner.nextLong();
            long y = scanner.nextLong();

            System.out.println("Sum: " + (x + y));
            System.out.println("Difference: " + (x - y));

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
