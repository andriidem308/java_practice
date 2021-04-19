package classwork_6;

import java.util.Scanner;

public class task_32 {
    static StringBuffer shiftByKey(String s, int k){
        StringBuffer shifted = new StringBuffer();

        for (int i = 0; i < s.length(); i++){
            char ch = (char)(((int)s.charAt(i) + k - 97) % 26 + 97);
            shifted.append(ch);
        }

        return shifted;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();
        System.out.println(shiftByKey(s, k));
    }
}
