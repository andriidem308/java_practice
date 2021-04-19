package bookmap_test_task;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static String fileInName = "./src/bookmap_test_task/input.txt";
    public static String fileOutName = "./src/bookmap_test_task/output.txt";
    public static FileWriter fileWriter;


    public static ArrayList<String[]> readFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        ArrayList<String[]> commands = new ArrayList<>();

        String line = bufferedReader.readLine();
        while (line != null) {
            String[] arguments = line.split(",");
            commands.add(arguments);
            line = bufferedReader.readLine();
        }

        fileReader.close();
        bufferedReader.close();

        return commands;
    }


    static <T> void fWrite(T s) throws IOException {
        fileWriter.write(s.toString() + "\n");
    }

    static void testMain() throws IOException{
        ArrayList<String[]> commands = readFile(fileInName);
        OrderBook orderBook = new OrderBook();
        fileWriter = new FileWriter(fileOutName);

        for (String[] cmd: commands){
            orderBook.Execute(cmd);
        }

        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
         testMain();
    }
}
