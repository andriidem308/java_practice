package homework_1;

import java.util.Scanner;

public class task_2_2 {
    public static String toBinary(int a){
        String b = "";
        for (int i = 7; i >= 0; i--){
            int delta = (int) Math.pow(2, i);
            b = b + a / delta;
            a = a % delta;
        }

        return b;
    }

    public static String shiftLeft(String a){
        String shiftedArray = a.substring(1) + a.charAt(0);
        return shiftedArray;
    }

    public static int toInteger(String b){
        int a = 0;

        for (int i = 0; i < 8; i++){
            if (b.charAt(i) == '1') {
                a += (int) Math.pow(2, 7-i);
            }
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextShort() % 256;
        String binaryNumber = toBinary(number);
        String shiftedBinaryNumber = shiftLeft(binaryNumber);
        int result = toInteger(shiftedBinaryNumber);
        System.out.println(result);
    }
}
