package university.classworks.classwork_8.task_1;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Passenger> readPassengers(String filePath) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(filePath));

        ArrayList<Passenger> passengers = new ArrayList<>();

        int i = 1;
        try {
            while (true) {
                String surname = dis.readLine().trim();
                Passenger new_passenger = new Passenger(surname, i);
                passengers.add(new_passenger);
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

    static Passenger get_by_id(ArrayList<Passenger> passengers, int id){
        for (Passenger p: passengers){
            if (p.id == id) return p;
        }

        return null;
    }

    static Passenger deltaLessThanKilo(ArrayList<Baggage> baggage_info, ArrayList<Passenger> passengers){
        double totalAvg = getTotalAverageWeight(baggage_info);

        for (Baggage b: baggage_info){
            if (Math.abs(getLocalAverageWeight(b) - totalAvg) <= 1){
                return get_by_id(passengers, b.id);
            }
        }

        return null;
    }



    public static void main(String[] args) throws IOException {
        String passengersPath = "src/university/classworks/classwork_8/task_1/b_passengers.dat";
        String baggagePath = "src/university/classworks/classwork_8/task_1/b_baggage.dat";
        String outputFilePath = "src/university/classworks/classwork_8/task_1/result.dat";

        ArrayList<Passenger> passengers = readPassengers(passengersPath);
        ArrayList<Baggage> baggage_info = readBaggage(baggagePath);

        System.out.println(getTotalAverageWeight(baggage_info));
        Passenger res_passenger = deltaLessThanKilo(baggage_info, passengers);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFilePath))) {
            oos.writeObject(res_passenger);
            System.out.println("File has been written");
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
