package homework_8;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class strings_task_3 {
    static ArrayList<String> getRepeats(String line){
        ArrayList<String> repeatsArray = new ArrayList<>();

        Pattern pattern = Pattern.compile("(.)\\1+");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()){
            String current_repeat = line.substring(matcher.start(), matcher.end());
            repeatsArray.add(current_repeat);
        }

        return repeatsArray;
    }

    static HashMap<Character, Integer> getRepeatsMap(String line){
        HashMap<Character, Integer> repeatCharLengthMap = new HashMap<>();
        ArrayList<String> repeatsArr = getRepeats(line);

        for (String r: repeatsArr){
            repeatCharLengthMap.put(r.charAt(0), r.length());
        }

        return repeatCharLengthMap;
    }

    static Map.Entry<Character, Integer> getLongestRepeat(String line){
        if (line.isEmpty()) return null;

        HashMap<Character, Integer> repeatCharLengthMap = getRepeatsMap(line);
        int maxLength = 0;
        char maxChar;
        Map.Entry<Character, Integer> maxEntry = null;

        for (Map.Entry<Character, Integer> entry : repeatCharLengthMap.entrySet()){
            if (entry.getValue() > maxLength){
                maxLength = entry.getValue();
                maxEntry = entry;
            }
        }

        return maxEntry;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map.Entry<Character, Integer> maxEntry = getLongestRepeat(line);

        String out = String.format("* Longest repeat\nCharacter: %c, length: %d",
                maxEntry.getKey(), maxEntry.getValue());
        System.out.println(out);


    }
}
