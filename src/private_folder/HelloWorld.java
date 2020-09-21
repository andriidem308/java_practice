package private_folder;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        String astr = Integer.toString(a);
        System.out.println(astr.length());

        double blog = Math.ceil(Math.log10(b));
        System.out.println(blog);

        double avgharm = 2/(1/Double.parseDouble(astr) + 1/blog);

        System.out.println(avgharm);
    }
}
