package topic_5_arrays;

import java.util.Scanner;

public class task_5_6 {
    public static boolean onlyEven(int number){
        int[] arr = toArray(number);

        for (int a: arr){
            if (a % 2 == 1) return false;
        }

        return true
    }

    public static boolean evenEqOdd(int number) {
        int[] arr = toArray(number);
        if (arr.length % 2 == 1) return false;

        int even = 0, odd = 0;
        for (int a: arr) {
            if (a % 2 == 0) even++;
            else odd++;
        }

        return even == odd;
    }

    public static int[] toArray(int number) {
        String str_arr = Integer.toString(number);
        int size = str_arr.length();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++){
            arr[i] = str_arr.charAt(i) - '0';
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int even_num = 0, even_odd_num = 0;
        String[] str_numbers = scanner.nextLine().split(" ");

        for (String snum : str_numbers) {
            int new_number = Integer.parseInt(snum);

            if (onlyEven(new_number)) even_num++;
            if (evenEqOdd(new_number)) even_odd_num++;
        }

        System.out.println("With only even digits: " + even_num);
        System.out.println("With the same number of both even and odd digits: " + even_odd_num);


    }
}
