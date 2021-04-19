package classwork_7;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class files_task_1 {
    static String FILE_IN_PATH = "src/classwork_7/input.txt";
    static String FILE_OUT_PATH = "src/classwork_7/output.txt";

    static String readFromFile(String fileInPath) throws IOException {
        FileReader fr = new FileReader(fileInPath);
        Scanner scanner = new Scanner(fr);
        String readLine = scanner.nextLine();
        fr.close();
        return readLine;
    }

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

    static void test_1(String s, FileWriter fileWriter) throws IOException {
        fileWriter.write("\nTest 1\n");

        ArrayList<String> wArr = getWordsArray(s);
        int maxLength = 0;
        String maxWord = "";

        for (String w: wArr){
            if (w.length() > maxLength){
                maxLength = w.length();
                maxWord = w;
            }
        }

        fileWriter.write("The longest word: " + maxWord + "\n");
    }

    static void test_2(String s, FileWriter fileWriter) throws IOException {
        fileWriter.write("\nTest 2\n");
        ArrayList<String> wArr = getWordsArray(s);
        fileWriter.write("Words amount: " + wArr.size() + "\n");
    }

    static void test_3(String s, FileWriter fileWriter) throws IOException {
        fileWriter.write("\nTest 3\n");

        String resString = s.replaceAll("\\s\\w\\s", " ");
        fileWriter.write("Result: " + resString + "\n");
    }

    static void test_4(String s, FileWriter fileWriter) throws IOException {
        fileWriter.write("\nTest 4\n");

        int fstSpaceIndex = s.indexOf(' ');
        String resString = s.substring(0, fstSpaceIndex + 1) +
                s.substring(fstSpaceIndex + 1).replaceAll("\\s", "");

        fileWriter.write("Result: " + resString + "\n");
    }

    static void test_5(String s, FileWriter fileWriter) throws IOException {
        fileWriter.write("\nTest 5\n");
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

        fileWriter.write(result + "\n");
    }

    public static void main(String[] args) throws IOException {
        String line = readFromFile(FILE_IN_PATH);
        String newLine = removeBeginEnd(line);

        FileWriter fw = new FileWriter(FILE_OUT_PATH);

        test_1(newLine, fw);
        test_2(newLine, fw);
        test_3(newLine, fw);
        test_4(newLine, fw);
        test_5(newLine, fw);

        fw.close();


    }
}
