package homework_8;

import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class files_task_6 {
    static String FILE_IN_PATH = "src/homework_8/input.txt";

    static ArrayList<String> getLinesFromFile(String fileInPath) throws IOException {
        FileReader fr = new FileReader(fileInPath);
        Scanner fileScanner = new Scanner(fr);

        ArrayList<String> linesArray = new ArrayList<>();

        while (fileScanner.hasNextLine()) {
            String newLine = fileScanner.nextLine();
            linesArray.add(newLine);
        }

        fr.close();
        return linesArray;
    }

    static String findTheLongestLine (String fileInPath) throws IOException {
        ArrayList<String> lines = getLinesFromFile(fileInPath);
        String longestLine = "";

        for (String line : lines){
            if (line.length() > longestLine.length()){
                longestLine = line;
            }
        }

        return longestLine;
    }

    public static void main(String[] args) throws IOException {
        String theLongestLine = findTheLongestLine(FILE_IN_PATH);
        System.out.println("The longest line:\n" + theLongestLine);
    }
}
