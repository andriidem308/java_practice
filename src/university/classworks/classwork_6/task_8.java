package classwork_6;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task_8 {
    static ArrayList<Integer> getElements(String expr){
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(expr);

        ArrayList<Integer> elements = new ArrayList<>();

        while (matcher.find()){
            elements.add(Integer.parseInt(expr.substring(matcher.start(), matcher.end())));
        }

        return elements;
    }

    static int getSumOfElements(ArrayList<Integer> elements){
        int sum = 0;
        for (Integer e: elements) sum += e;

        return sum;
    }

    static boolean isArithmeticProgression(String s){
        if (s.length() == 1) return true;
        if (s.length() == 2) return true;

        ArrayList<Integer> elements = getElements(s);
        int d = elements.get(1) - elements.get(0);

        for (int i = 2; i < elements.size(); i++){
            if (elements.get(i) - elements.get(i-1) != d) return false;
        }

        return true;
    }

    static void test_1(String s){
        System.out.println("Test 1");
        if (s.matches("\\d+")){
            ArrayList<Integer> digits = getElements(s);
            int size = digits.size();

            boolean by9 = (getSumOfElements(digits) % 9 == 0);
            boolean by4 = (Integer.parseInt(s.substring(size-2)) % 4 == 0);
            boolean by6 = (getSumOfElements(digits) % 3 == 0 && Character.getNumericValue(s.charAt(size-1)) % 2 == 0);

            System.out.println("Divides by 9: " + by9);
            System.out.println("Divides by 4: " + by4);
            System.out.println("Divides by 6: " + by6);
        }
        else {
            System.out.println("It is not a number");
        }
    }

    static void test_2(String s){
        System.out.println("\nTest 2");
        System.out.print("Result: ");
        if (s.matches("[1-9][a-zA-Z]+")){
            boolean result = Character.getNumericValue(s.charAt(0)) == s.length() - 1;
            System.out.println(result);
        }
        else {
            System.out.println(false);
        }
    }

    static void test_3(String s){
        System.out.println("\nTest 3");
        System.out.print("Result: ");
        if (s.matches("[a-zA-Z]*[0-9][a-zA-Z]*")){
            boolean result = Integer.parseInt(s.replaceAll("[^0-9]", "")) == s.length();
            System.out.println(result);
        }
        else {
            System.out.println(false);
        }
    }

    static void test_4(String s){
        System.out.println("\nTest 4");
        System.out.print("Result: ");
        boolean result = getSumOfElements(getElements(s)) == s.length();
        System.out.println(result);
    }

    static void test_5(String s){
        System.out.println("\nTest 5");
        System.out.print("Result: ");

        String primary = "0123456789";
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(primary);

        System.out.println(matcher.find());
    }

    static void test_6(String s){
        System.out.println("\nTest 6");
        System.out.print("Result: ");
        if (s.matches("[0-9]+")){
            System.out.println(isArithmeticProgression(s));
        }
        else {
            System.out.println(false);
        }
    }

    public static void main(String[] args) {
        String s1 = "363618";
        String s2 = "4abcd";
        String s3 = "a4de";
        String s4 = "ab1c2de4f3";
        String s5 = "3456";
        String s6 = "3579";

        test_1(s1);
        test_2(s2);
        test_3(s3);
        test_4(s4);
        test_5(s5);
        test_6(s6);
    }
}
