package university.homeworks.homework_9.IntegerSet;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String inputFilename = "src/university/homeworks/homework_9/IntegerSet/input.dat";
        String outputFilename = "src/university/homeworks/homework_9/IntegerSet/output.dat";

        IntegerSet integerSet = new IntegerSet(inputFilename, outputFilename);
        integerSet.test();
    }
}
