package homework_7;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task_9 {
    static void procedure(String s){
        Pattern pattern = Pattern.compile("(.)\\1{1,}");
        Matcher matcher = pattern.matcher(s);

        ArrayList<String> repeats = new ArrayList<>();

        while (matcher.find()){
            repeats.add(s.substring(matcher.start(), matcher.end()));
        }

        if (repeats.isEmpty()) {
            System.out.println("Sym: " + s.charAt(0) + "\nLength: 1");
        }
        else {
            char maxSymbol = repeats.get(0).charAt(0);
            int maxLength = repeats.get(0).length();

            if (repeats.size() > 1){
                for (int i = 1; i < repeats.size(); i++){
                    char sym = repeats.get(i).charAt(0);
                    int len = repeats.get(i).length();

                    if (len > maxLength){
                        maxLength = len;
                        maxSymbol = sym;
                    }
                }
            }

            System.out.println("Sym: " + maxSymbol + "\nLength: " + maxLength);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        procedure(s);
    }
}
