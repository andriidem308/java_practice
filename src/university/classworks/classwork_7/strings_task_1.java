package classwork_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class strings_task_1 {
    static String removeBeginEnd(String s){
        String resString = s.replaceAll("^(\\s)*", "");
        resString = resString.replaceAll("(\\s)*$", "");
        resString = resString.replaceAll("(\\s){2,}", " ");

        return resString;
    }

    static ArrayList<String> getWordsArray(String s){
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(s);

        ArrayList<String> words = new ArrayList<>();

        while (matcher.find()){
            words.add(s.substring(matcher.start(), matcher.end()));
        }

        return words;
    }

    static int getTotalLetters(ArrayList<String> wArr){
        int total = 0;
        for (String w: wArr) total += w.length();

        return total;
    }

    static void test_1(String s){
        System.out.println("\nTest 1");

        ArrayList<String> wArr = getWordsArray(s);
        int maxLength = 0;
        String maxWord = "";

        for (String w: wArr){
            if (w.length() > maxLength){
                maxLength = w.length();
                maxWord = w;
            }
        }

        System.out.println("The longest word: " + maxWord);
    }
    static void test_2(String s){
        System.out.println("\nTest 2");
        ArrayList<String> wArr = getWordsArray(s);
        System.out.println("Words amount: " + wArr.size());
    }
    static void test_3(String s){
        System.out.println("\nTest 3");

        String resString = s.replaceAll("\\s\\w\\s", " ");
        System.out.println("Result: " + resString);
    }
    static void test_4(String s){
        System.out.println("\nTest 4");

        int fstSpaceIndex = s.indexOf(' ');
        String resString = s.substring(0, fstSpaceIndex + 1) +
                s.substring(fstSpaceIndex + 1).replaceAll("\\s", "");

        System.out.println("Result: " + resString);
    }

    static void test_5(String s){
        System.out.println("\nTest 5");
        ArrayList<String> wArr = getWordsArray(s);
        int maxSymbols = 80;
        int spacesAmount = wArr.size() - 1;
        int totalLetters = getTotalLetters(wArr);

        int smallSpaceLen = (maxSymbols - totalLetters) / spacesAmount;
        int bigSpaceLen = smallSpaceLen + 1;
        int bigSpacesAmount = (maxSymbols - totalLetters) - smallSpaceLen * spacesAmount;

        char[] big = new char[bigSpaceLen];
        char[] small = new char[smallSpaceLen];
        Arrays.fill(big, ' ');
        Arrays.fill(small, ' ');

        String bigSpace = new String(big);
        String smallSpace = new String(small);

        int i = 0;
        String result = wArr.get(0);
        for (String w: wArr.subList(1, wArr.size())){
            result += (i < bigSpacesAmount) ? bigSpace : smallSpace;
            result += w;
            i++;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
        String line = "  today  is   Tuesday a   fifth of  August   ";
        String testString = removeBeginEnd(line);
        
        test_1(testString);
        test_2(testString);
        test_3(testString);
        test_4(testString);
        test_5(testString);

    }
}
