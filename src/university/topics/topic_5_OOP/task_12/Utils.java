package topic_5_OOP.task_12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Utils {
    public static ArrayList<Tariff> readFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fileReader);

        ArrayList<Tariff> tariffs = new ArrayList<>();

        String line = reader.readLine();
        while (line != null){
            String[] args = line.split(" ");

            String tn = args[0];
            int p = Integer.parseInt(args[1]);
            int sms = Integer.parseInt(args[2]);
            int calls = Integer.parseInt(args[3]);
            int mb = Integer.parseInt(args[4]);
            int foreign = Integer.parseInt(args[5]);

            ArrayList<String> clients = new ArrayList<>();
            if (args.length > 6) {
                for(int i = 6; i < args.length; i++){ clients.add(args[i]);}
            }

            Tariff newTariff = new Tariff(tn, p, sms, calls, mb, foreign, clients);
            tariffs.add(newTariff);

            line = reader.readLine();
        }

        fileReader.close();
        reader.close();

        return tariffs;
    }

    public static int allClientsAmount(ArrayList<Tariff> tariffs){
        int clientsAmount = 0;
        for (Tariff t: tariffs){
            clientsAmount += t.getClientsAmount();
        }

        return clientsAmount;
    }

    public static void selectionSort(ArrayList<Tariff> array){
        int size = array.size();
        int i, j, highestValueIndex;

        for (i = 0; i < size; i++){
            highestValueIndex = i;

            for (j = i + 1; j < size; j++){
                if (array.get(j).price > array.get(highestValueIndex).price){
                    highestValueIndex = j;
                }
            }

            Collections.swap(array, i, highestValueIndex);
        }
    }

    public static ArrayList<Tariff> sortByPrice(ArrayList<Tariff> tariffs){
        ArrayList<Tariff> sortedTariffs = new ArrayList<>();
        sortedTariffs.addAll(tariffs);
        selectionSort(sortedTariffs);
        return sortedTariffs;
    }
}
