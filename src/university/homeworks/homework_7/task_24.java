package homework_7;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task_24 {
    static int getLength(String s, char c){
        return s.lastIndexOf(c) - s.indexOf(c) + 1;
    }

    static HashSet<Character> getUnique(String s){
        HashSet<Character> charactersHashSet = new HashSet<>();
        for (char c: s.toCharArray()) charactersHashSet.add(c);

        return charactersHashSet;
    }

    static HashMap<Character, Integer> getSymbolsAndTheirLengths(String line){
        HashSet<Character> characters = getUnique(line);
        HashMap<Character, Integer> symsAndLengths = new HashMap<>();

        for (char character: characters){
            symsAndLengths.put(character, getLength(line, character));
        }

        return symsAndLengths;
    }

    static char getMaxSymbol(String s){
        HashMap<Character, Integer> satl = getSymbolsAndTheirLengths(s);
        int maxLength = 0;
        char maxSymbol = ' ';

        for (Map.Entry<Character, Integer> entry : satl.entrySet()) {
            if (entry.getValue() > maxLength) {
                maxLength = entry.getValue();
                maxSymbol = entry.getKey();
            }
        }

        return maxSymbol;
    }

    static void procedure(String s){
        char maxSymbol = getMaxSymbol(s);
        String subLine = s.substring(s.indexOf(maxSymbol), s.lastIndexOf(maxSymbol) + 1);
        System.out.println("The longest sub line: " + subLine);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        procedure(A);
    }
}
