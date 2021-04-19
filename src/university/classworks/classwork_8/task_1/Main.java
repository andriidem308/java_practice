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

<<<<<<< HEAD
    static double getTotalAverageWeight(ArrayList<Baggage> b_info){
        double sum = 0.0;
        int amount = 0;

        for (Baggage b: b_info){
            sum += b.weight;
            amount += b.amount;
        }

        return sum / amount;
=======
    static int getTotalThingsAmount(ArrayList<Baggage> bArr){
        int totalAmount = 0;
        for (Baggage b: bArr) totalAmount += b.amount;

        return totalAmount;
    }

    static int getTotalThingsWeight(ArrayList<Baggage> bArr){
        int totalWeight = 0;
        for (Baggage b: bArr) totalWeight += b.weight;

        return totalWeight;
    }

    static double getTotalAverageWeight(ArrayList<Baggage> b_info){
        int totalWeight = getTotalThingsWeight(b_info);
        int totalAmount = getTotalThingsAmount(b_info);

        return (totalWeight + 0.0) / totalAmount;
>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518
    }

    static double getLocalAverageWeight(Baggage baggage){

        return baggage.weight / (baggage.amount + 0.0);
    }

<<<<<<< HEAD
    static Passenger get_by_id(ArrayList<Passenger> passengers, int id){
=======
    static Passenger getById(ArrayList<Passenger> passengers, int id){
>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518
        for (Passenger p: passengers){
            if (p.id == id) return p;
        }

        return null;
    }

    static Passenger deltaLessThanKilo(ArrayList<Baggage> baggage_info, ArrayList<Passenger> passengers){
        double totalAvg = getTotalAverageWeight(baggage_info);

        for (Baggage b: baggage_info){
            if (Math.abs(getLocalAverageWeight(b) - totalAvg) <= 1){
<<<<<<< HEAD
                return get_by_id(passengers, b.id);
=======
                return getById(passengers, b.id);
>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518
            }
        }

        return null;
    }

<<<<<<< HEAD

=======
    static ArrayList<Passenger> hasMoreThanTwoThings(ArrayList<Baggage> bArr, ArrayList<Passenger> pArr){
        ArrayList<Passenger> resArr = new ArrayList<>();
        for (Baggage b: bArr){
            if (b.amount > 2){
                resArr.add(getById(pArr, b.id));
            }
        }

        return resArr;
    }

    static ArrayList<Passenger> moreThanAvgAmount(ArrayList<Baggage> bArr, ArrayList<Passenger> pArr){
        ArrayList<Passenger> resArr = new ArrayList<>();
        int totalAmount = getTotalThingsAmount(bArr);
        int totalPassengersAmount = pArr.size();

        double avgAmount = (totalAmount + 0.0) / totalPassengersAmount;

        for (Baggage b: bArr){
            if (b.amount > avgAmount)
                resArr.add(getById(pArr, b.id));
        }

        return resArr;
    }

    static void task_a(ArrayList<Baggage> bArr, ArrayList<Passenger> pArr, String filename){
        System.out.println("\n --- TASK A ---");

        Passenger sPass = deltaLessThanKilo(bArr, pArr);

        System.out.println("BEFORE Serialization: " + sPass);

        // --- SERIALIZING ---
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(sPass);
            System.out.println("SERIALIZED");
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        // --- DESERIALIZING ---
        Passenger dsPass = new Passenger();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            dsPass = ((Passenger) ois.readObject());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("AFTER Deserialization: " + dsPass);
    }

    static void task_b(ArrayList<Baggage> bArr, ArrayList<Passenger> pArr, String filename){
        System.out.println("\n --- TASK B ---");
        ArrayList<Passenger> pArr_1 = hasMoreThanTwoThings(bArr, pArr);
        ArrayList<Passenger> pArr_2 = moreThanAvgAmount(bArr, pArr);

        System.out.println("\nBEFORE Serialization");
        System.out.println("\nHas more than 2 things:");
        for (Passenger p: pArr_1) System.out.println(p);
        System.out.println("\nHas more things than avg amount:");
        for (Passenger p: pArr_2) System.out.println(p);

        // --- SERIALIZING ---
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(pArr_1);
            oos.writeObject(pArr_2);
            System.out.println("\n *** SERIALIZED ***");
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        // --- DESERIALIZING ---
        ArrayList<Passenger> pdsArr_1 = new ArrayList<>();
        ArrayList<Passenger> pdsArr_2 = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            pdsArr_1 = ((ArrayList<Passenger>) ois.readObject());
            pdsArr_2 = ((ArrayList<Passenger>) ois.readObject());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("\nAFTER Serialization");
        System.out.println("\nHas more than 2 things:");
        for (Passenger p: pdsArr_1) System.out.println(p);
        System.out.println("\nHas more things than avg amount:");
        for (Passenger p: pdsArr_2) System.out.println(p);

    }
>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518

    public static void main(String[] args) throws IOException {
        String passengersPath = "src/university/classworks/classwork_8/task_1/b_passengers.dat";
        String baggagePath = "src/university/classworks/classwork_8/task_1/b_baggage.dat";
<<<<<<< HEAD
        String outputFilePath = "src/university/classworks/classwork_8/task_1/result.dat";
=======
        String fileTaskA = "src/university/classworks/classwork_8/task_1/task_a.dat";
        String fileTaskB = "src/university/classworks/classwork_8/task_1/task_b.dat";
>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518

        ArrayList<Passenger> passengers = readPassengers(passengersPath);
        ArrayList<Baggage> baggage_info = readBaggage(baggagePath);

<<<<<<< HEAD
        System.out.println(getTotalAverageWeight(baggage_info));
        Passenger res_passenger = deltaLessThanKilo(baggage_info, passengers);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFilePath))) {
            oos.writeObject(res_passenger);
            System.out.println("File has been written");
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
=======
        task_a(baggage_info, passengers, fileTaskA);
        task_b(baggage_info, passengers, fileTaskB);

>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518

    }
}
