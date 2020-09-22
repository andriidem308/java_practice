package topic_5_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class task_5_7 {
    public static boolean checkIncreaseDigits(int number){
        int[] digits = toArray(number);
        boolean flag = true;

        int prev = digits[0];
        for (int d: Arrays.copyOfRange(digits, 1, digits.length)){
            if (d <= prev) flag = false;
            prev = d;
        }

        return flag;
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

        String[] str_numbers = scanner.nextLine().split(" ");
        int size = str_numbers.length;

        for (int i = 0; i < size; i++){
            int new_number = Integer.parseInt(str_numbers[i]);

            if (checkIncreaseDigits(new_number)) {
                System.out.println(new_number);
            }
        }
    }
}
