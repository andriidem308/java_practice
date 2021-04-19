package topic_5_OOP.task_12;

/*
 * Мобільний зв'язок. Визначити ієрархію тарифів мобільної компанії.
 * Створити список тарифів компанії. Підрахувати загальну кількість клієнтів.
 * Провести сортування тарифів на базі розміру абонентської плати.
 * Знайти тариф в компаніі, що відповідає заданому діапазону параметрів.
 */

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static String fileInName = "./src/topic_5_OOP/task_12/input.txt";

    public static void ListOfTariffs(ArrayList<Tariff> tariffsArray){
        for (Tariff t: tariffsArray) System.out.println(t);
        System.out.println();
    }

    public static void allClientsNumber(ArrayList<Tariff> tariffsArray){
        int amount = Utils.allClientsAmount(tariffsArray);
        System.out.println("All clients amount: " + amount);
        System.out.println();
    }

    public static void getSortedTariffs(ArrayList<Tariff> tariffsArray){
        ArrayList<Tariff> sortedArray = Utils.sortByPrice(tariffsArray);
        for (Tariff st: sortedArray) System.out.println(st);
        System.out.println();
    }

    public static void findTariff(ArrayList<Tariff> tariffArray, int price,
                                  int freeSMS, int freeCalls, int mb, int foreign){
        for (Tariff t: tariffArray){
            if (price >= t.price && freeSMS <= t.freeSMS && freeCalls <= t.freeCalls
                    && mb <= t.internetMB && foreign <= t.foreignCalls){
                System.out.println("Suitable tariff: " + t);
                break;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Tariff> tariffs = Utils.readFile(fileInName);

        ListOfTariffs(tariffs);
        allClientsNumber(tariffs);
        getSortedTariffs(tariffs);
        findTariff(tariffs, 120, 50, 50, 8000, 0);
    }
}
