package topic_5_arrays;

import java.util.Scanner;

public class task_5_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str_numbers = scanner.nextLine().split(" ");
        int size = str_numbers.length;
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++)
            numbers[i] = Integer.parseInt(str_numbers[i]);

        int max_num = numbers[0], max_runs = 1;
        int tmp_num = numbers[0], tmp_runs = 1;

        for (int i = 1; i < size; i++){
            if (numbers[i] == tmp_num) {
                tmp_runs++;
                if ((tmp_runs > max_runs) || ((tmp_runs == max_runs) && (tmp_num > max_num))) {
                    max_runs = tmp_runs;
                    max_num = tmp_num;
                }
            } else {
                tmp_num = numbers[i];
                tmp_runs = 1;
            }
        }

        System.out.printf("Longest run: %d consecutive %ds", max_runs, max_num);
    }
}
