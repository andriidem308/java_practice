package topic_5_OOP.task_1;

/*
 * Квіткарня. Визначити ієрархію квітів. Створити кілька об'єктів-квіток.
 * Зібрати букет (використовуючи аксесуари) з визначенням його вартості.
 * Провести сортування квітів в букеті на основі рівня свіжості.
 * Знайти квітку в  букеті, що відповідає заданому діапазону довжини стебля.
 */

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static String fileInName = "./src/topic_5_OOP/task_1/task_3_in.txt";

    public static void printBouquetPrice(ArrayList<Flower> bouquet){
        System.out.println("Bouquet price: " + Utils.calcBouquetPrice(bouquet));
        System.out.println();
    }
    public static void printSortedBouquet(ArrayList<Flower> bouquet){
        System.out.println("Sorted Bouquet:");
        for (Flower f: Utils.sortBouquet(bouquet)) System.out.println(f);
        System.out.println();
    }
    public static void printFoundFlower(ArrayList<Flower> bouquet, double a, double b){
        if (Utils.lengthBetween(bouquet, a, b) == null) System.out.println("Not found!");
        System.out.println("Found: " + Utils.lengthBetween(bouquet, a, b));
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Bouquet bouquet = Utils.readFile(fileInName);
//        printBouquetPrice(bouquet);
//        printSortedBouquet(bouquet);
//        printFoundFlower(bouquet, 17, 20);

        ArrayList<Flower> flowerSorted = bouquet.getSortedByFreshness();

        for (Flower fs: flowerSorted){
            System.out.println(fs);
        }

    }
}
