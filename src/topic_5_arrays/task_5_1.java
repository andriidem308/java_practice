package topic_5_arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class task_5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        int min=0, max=0;

        boolean flag = true;
        try {
            String line = scanner.nextLine();
            numbers.add(Integer.parseInt(line));
            min = numbers.get(0);
            max = numbers.get(0);
        } catch (NumberFormatException nfe) {
            flag = false;
        }

        while (flag) {
            try {
                String line = scanner.nextLine();
                int new_num = Integer.parseInt(line);
                numbers.add(new_num);

                min = (new_num < min) ? new_num : min;
                max = (new_num > max) ? new_num : max;

            } catch (NumberFormatException nfe) {
                break;
            }
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
