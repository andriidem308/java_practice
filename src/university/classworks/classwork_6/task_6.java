package classwork_6;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task_6 {
    static ArrayList<Integer> getElements(String expr){
        Pattern pattern = Pattern.compile("[+-]\\d");
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

    static void execute(String expression){
        System.out.println("Sum: " + getSumOfElements(getElements(expression)));
    }

    public static void main(String[] args) {
//        String expression = "-4+8-1-2+3+7+4+5-9.";  // -> 11
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        execute(expression);
    }
}
