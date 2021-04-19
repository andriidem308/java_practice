package university.homeworks.homework_9;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class task_3 {
    static String serFilePath = "src/university/homeworks/homework_9/inputOther.dat";
    static String inputFile = "src/university/homeworks/homework_9/task_3_in.txt";

    static HashSet<Integer> readFromFile(String filename) throws FileNotFoundException {
        FileReader fr = new FileReader(filename);
        Scanner scanner = new Scanner(fr);

        String[] lineArray = scanner.nextLine().split(" ");
        HashSet<Integer> readSet = new HashSet<>();

        for (String x : lineArray){
            readSet.add(Integer.parseInt(x));
        }

        return readSet;
    }

    static void serialize(HashSet<Integer> set, String filename){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(set);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static HashSet<Integer> deserialize(String filename){
        HashSet<Integer> arr = new HashSet<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            arr = ((HashSet<Integer>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return arr;
    }

    public static void main(String[] args) throws FileNotFoundException {
        HashSet<Integer> hset = readFromFile(inputFile);
        serialize(hset, serFilePath);
    }
}
