package classwork_1;

import java.util.Scanner;

public class task_2_1 {
    public static String toBinary(int a, int b, int size){
        String a_bin = "";
        for (int i = size-1; i >= 0; i--){
            int delta = (int) Math.pow(2, i);
            int mbit = a / delta;

            if (i == b) {
                mbit = (mbit == 0) ? 1 : 0;
            }

            a_bin += mbit;
            a = a % delta;
        }


        return a_bin;
    }

    public static int toInteger(String b, int size){
        int a = 0;

        for (int i = 0; i < size; i++){
            if (b.charAt(i) == '1') {
                a += (int) Math.pow(2, size-1-i);
            }
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();

        int max_length = Math.max(m, n);

        String n_binary = toBinary(n, m, max_length);
        int n_new = toInteger(n_binary, max_length);

        System.out.println("Result: " + n_new);
    }
}
