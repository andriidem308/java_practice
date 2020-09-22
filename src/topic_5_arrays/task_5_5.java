package topic_5_arrays;

import java.util.Scanner;

public class task_5_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] str_numbers = scanner.nextLine().split(" ");
        int size = str_numbers.length;
        int[] numbers = new int[size];
        int[] numbers_sizes = new int[size];

        for (int i = 0; i < size; i++){
            numbers[i] = Integer.parseInt(str_numbers[i]);
            numbers_sizes[i] = String.valueOf(Math.abs(numbers[i])).length();
        }

        int min_number = numbers[0];
        int min_length = numbers_sizes[0];

        for (int i = 0; i < size; i++){
            if (numbers_sizes[i] <= min_length){
                min_length = numbers_sizes[i];
                min_number = numbers[i];
            }
        }

        System.out.println("The shortest number: " + min_number);
        System.out.println("Amount of digits: " + min_length);


    }
}
