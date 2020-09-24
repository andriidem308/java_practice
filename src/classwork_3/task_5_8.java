package classwork_3;

import java.util.ArrayList;
import java.util.Scanner;

public class task_5_8 {
    public static boolean hasDifferentDigits(int number){
        int[] digits = toArray(number);
        ArrayList<Integer> used_digits = new ArrayList<>();

        for (int d: digits){
            if (contains(used_digits, d)){
                return false;
            }

            used_digits.add(d);
        }

        return true;
    }

    public static boolean contains(ArrayList<Integer> array, int key){
        for (int i = 0; i < array.size(); i++){
            if (array.get(i) == key) return true;
        }

        return false;
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
            if (hasDifferentDigits(new_number)){
                System.out.println(new_number);
            }
        }
    }
}
