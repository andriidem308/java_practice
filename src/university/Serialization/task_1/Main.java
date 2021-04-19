package Serialization.task_1;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static HashMap<Integer, String> readPassengers(String filePath) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(filePath));

        HashMap<Integer, String> passengers = new HashMap<>();

        int i = 1;
        try {
            while (true) {
                String surname = dis.readLine().trim();
                passengers.put(i, surname);
                i++;
            }
        }
        catch (EOFException | NullPointerException ignored) { dis.close(); }

        return passengers;
    }

    static ArrayList<Baggage> readBaggage(String filePath) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(filePath));

        ArrayList<Baggage> baggage_info = new ArrayList<>();

        try {
            while (true) {
                String[] infoArr = dis.readLine().split(" ");
                ArrayList<Integer> b_int = new ArrayList<>();
                for (String sbi: infoArr){
                    byte[] sbiBytes = sbi.trim().getBytes();
                    String a = "";
                    for (int i = 0; i < sbiBytes.length; i+=2){
                        a += Character.toString(sbiBytes[i]);
                    }

                    b_int.add(Integer.parseInt(a));
                }

                Baggage baggage = new Baggage(b_int.get(0), b_int.get(1), b_int.get(2));

                baggage_info.add(baggage);

            }
        }
        catch (EOFException | NullPointerException ignored) { dis.close(); }

        return baggage_info;
    }

    static double getTotalAverageWeight(ArrayList<Baggage> b_info){
        double sum = 0.0;
        int amount = 0;

        for (Baggage b: b_info){
            sum += b.weight;
            amount += b.amount;
        }

        return sum / amount;
    }

    static double getLocalAverageWeight(Baggage baggage){

        return baggage.weight / (baggage.amount + 0.0);
    }

    static String deltaLessThanKilo(ArrayList<Baggage> baggage_info, HashMap<Integer, String> passengers){
        double totalAvg = getTotalAverageWeight(baggage_info);

        for (Baggage b: baggage_info){
            if (Math.abs(getLocalAverageWeight(b) - totalAvg) <= 1){
                return passengers.get(b.id) + " " + getLocalAverageWeight(b);
            }
        }

        return "None";
    }



    public static void main(String[] args) throws IOException {
        String passengersPath = "src/Serialization/task_1/b_passengers.dat";
        String baggagePath = "src/Serialization/task_1/b_baggage.dat";

        HashMap<Integer, String> passengers = readPassengers(passengersPath);
        ArrayList<Baggage> baggage_info = readBaggage(baggagePath);

        System.out.println(getTotalAverageWeight(baggage_info));
        System.out.println(deltaLessThanKilo(baggage_info, passengers));
    }
}
