package classwork_2;

import java.util.Scanner;

public class task_3_3 {
    public static void check(boolean condition) throws Exception {
        if (!condition) {
            throw new Exception("Bad data!!!");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int month, day, year;

        month = scanner.nextInt();
        check(month >= 1 && month <= 12);
        day = scanner.nextInt();
        check (day >= 1 && day <= 31);
        year = scanner.nextInt();
        check (year >= 2000 && year <= 2100);

        String date = month + "." + day + "." + year;
        boolean leapYear = (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0));

        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                check (day <= 30);
            case 2:
                check (day <= ((leapYear) ? 29 : 28));
        }


        System.out.println("Date: " + date);
        switch (month) {
            case 1 -> System.out.println("Січень");
            case 2 -> System.out.println("Лютий");
            case 3 -> System.out.println("Березень");
            case 4 -> System.out.println("Квітень");
            case 5 -> System.out.println("Травень");
            case 6 -> System.out.println("Червень");
            case 7 -> System.out.println("Липень");
            case 8 -> System.out.println("Серпень");
            case 9 -> System.out.println("Вересень");
            case 10 -> System.out.println("Жовтень");
            case 11 -> System.out.println("Листопад");
            case 12 -> System.out.println("Грудень");
        }
    }
}
