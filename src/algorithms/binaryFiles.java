package algorithms;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class binaryFiles {

    public static void writeToBinaryFile(String fName, String data) {
        try (
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(new FileOutputStream(fName)))) {
            dos.writeChars(data);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readFromBinaryFile(String fName) {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(new FileInputStream(fName)))) {
            byte[] buffer = new byte[dis.available()];
            int i = -1;
            while ((i = dis.read()) != -1) {

                System.out.print((char) i);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {

        String data1 = Files.readString(Path.of("src/algorithms/passengers.txt"));
        writeToBinaryFile("src/algorithms/b_passengers.dat", data1);
        String data2 = Files.readString(Path.of("src/algorithms/baggage.txt"));
        writeToBinaryFile("src/algorithms/b_baggage.dat", data2);


    }
}
