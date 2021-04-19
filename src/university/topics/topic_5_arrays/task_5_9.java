package topic_5_arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class task_5_9 {
    public static boolean isPalindrome(int number) {
        String s = Integer.toString(number);

        int n = s.length();
        for (int i = 0; i < (n/2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] str_numbers = scanner.nextLine().split(" ");
        int size = str_numbers.length;
        ArrayList<Integer> palindromes = new ArrayList<>();

        for (int i = 0; i < size; i++){
            int new_number = Integer.parseInt(str_numbers[i]);
            if (isPalindrome(new_number)){
                palindromes.add(new_number);
            }
        }

        if (palindromes.size() == 0){
            System.out.println("There is no palindromes!");
        } else if (palindromes.size() == 1) {
            System.out.println(palindromes.get(0));
        } else {
            System.out.println(palindromes.get(1));
        }

    }
}
