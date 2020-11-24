package classwork_1;

import java.util.Scanner;

public class task_1_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arguments = scanner.nextLine().split("\\s+");
        int n = arguments.length;

        for (int i = 0; i < n; i++){
            System.out.print(arguments[n-i-1] + " ");
        }
    }
}
