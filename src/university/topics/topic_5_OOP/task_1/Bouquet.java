package topic_5_OOP.task_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Bouquet {
    ArrayList<Item> items;

    Bouquet(){
        items = new ArrayList<>();
    }

    void addItem(Item x){
        items.add(x);
    }

    void removeItem(Item x){
        items.remove(x);
    }

    float getPrice() {
        float sum = 0;
        for (Item item: items) sum += item.price;
        return sum;
    }

    ArrayList<Flower> getSortedByFreshness(){
        ArrayList<Flower> sortedFlowers = new ArrayList<>();
        for (Item item: items){
            if (item instanceof Flower)
                sortedFlowers.add((Flower) item);
        }

        int size = sortedFlowers.size();
        int i, j, h;

        for (i = 0; i < size; i++){
            h = i;

            for (j = i + 1; j < size; j++){
                if (sortedFlowers.get(j).freshness > sortedFlowers.get(h).freshness){
                    h = j;
                }
            }

            Collections.swap(sortedFlowers, i, h);
        }

        return sortedFlowers;
    }
}
