package topic_5_OOP.task_1;

import topic_5_OOP.task_12.Tariff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Utils {
    public static Bouquet readFile(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fr);

        Bouquet bouquet = new Bouquet();

        String line = reader.readLine();
        while (!line.trim().isEmpty()) {
            String[] flowerArgs = line.split(" ");

            String name = flowerArgs[0];
            double price = Double.parseDouble(flowerArgs[1]);
            int freshness = Integer.parseInt(flowerArgs[2]);
            double flen = Double.parseDouble(flowerArgs[3]);

            Flower newFlower = new Flower(name, price, freshness, flen);
            bouquet.addItem(newFlower);

            line = reader.readLine();
        }

        fr.close();
        reader.close();

        return bouquet;
    }

    public static double calcBouquetPrice(ArrayList<Flower> bouquet){
        double cost = 0;
        for (Flower f: bouquet) cost += f.price;
        return cost;
    }

    public static Flower lengthBetween(ArrayList<Flower> bouquet, double a, double b){
        for (Flower f: bouquet) {
            if (f.flen >= a && f.flen <= b) return f;
        }
        return null;
    }

    public static void selectionSort(ArrayList<Flower> array){
        int size = array.size();
        int i, j, highestValueIndex;

        for (i = 0; i < size; i++){
            highestValueIndex = i;

            for (j = i + 1; j < size; j++){
                if (array.get(j).freshness > array.get(highestValueIndex).freshness){
                    highestValueIndex = j;
                }
            }

            Collections.swap(array, i, highestValueIndex);
        }
    }

    public static ArrayList<Flower> sortBouquet(ArrayList<Flower> bouquet){
        ArrayList<Flower> sortedBouquet = new ArrayList<>(bouquet);
        selectionSort(sortedBouquet);
        return sortedBouquet;
    }
}
