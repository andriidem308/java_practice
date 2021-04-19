package classwork_2;

import java.util.Scanner;

public class task_4_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int i = 0;

        while (true) {
            System.out.printf("a[%d]=", i);
            int a = scanner.nextInt();
            if (a == 0) break;
            i += 1;
            sum += a;
        }

        System.out.println("\nSum: " + sum);

    }
}
