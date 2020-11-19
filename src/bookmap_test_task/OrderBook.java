package bookmap_test_task;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OrderBook {
    HashMap<String, HashMap<Integer, Integer>> orderBook;

    OrderBook(){
        orderBook = new HashMap<>();
    }

    void Execute(String[] command) throws IOException {
        try {
            if (command[0].equals("u")) {
                int price = Integer.parseInt(command[1]);
                int size = Integer.parseInt(command[2]);

                Update(price, size, command[3]);
            }
            if (command[0].equals("q")) {
                if (command[1].equals("best_ask")) printBestAsk();
                if (command[1].equals("best_bid")) printBestBid();
                if (command[1].equals("size")) getSizeOfPrice(command[2]);
            }
            if (command[0].equals("o")) {
                if (command[1].equals("buy")) Buy(Integer.parseInt(command[2]));
                if (command[1].equals("sell")) Sell(Integer.parseInt(command[2]));
            }
        } catch (IndexOutOfBoundsException indexError){
            System.out.println("Invalid input!");
            Main.fWrite("Invalid input!");
            System.exit(1);
        }
    }

    void Update(int price, int size, String type){
        if (!orderBook.containsKey(type)){
            orderBook.put(type, new HashMap<>());
        }

        orderBook.get(type).put(price, size);
    }

    void Remove(int price, String type){
        if (!orderBook.containsKey(type) || !orderBook.get(type).containsKey(price)) {
            return;
        }

        orderBook.get(type).remove(price);
    }

    void Buy(int size){
        int askSize = getSizeOf("ask");

        while (askSize > 0 && size > 0){
            int[] bestAsk = getBestAsk();

            if (size >= bestAsk[1]) {
                size -= bestAsk[1];
                Remove(bestAsk[0],"ask");
            } else {
                Update(bestAsk[0], bestAsk[1] - size, "ask");
                size = 0;
            }
        }
    }

    void Sell(int size){
        int bidSize = getSizeOf("bid");

        while (bidSize > 0 && size > 0){
            int[] bestBid = getBestBid();

            if (size >= bestBid[1]) {
                size -= bestBid[1];
                Update(bestBid[0], 0, "bid");
            } else {
                Update(bestBid[0], bestBid[1] - size, "bid");
                size = 0;
            }
        }
    }

    int[] getBestAsk(){
        int[] bestAsk = new int[]{-1_000_000_000, 0};

        for (Map.Entry<Integer, Integer> ask : orderBook.get("ask").entrySet()){
            if (ask.getKey() < bestAsk[0] && ask.getValue() > 0)
                bestAsk = new int[]{ask.getKey(), ask.getValue()};
        }

        return bestAsk;
    }

    int[] getBestBid(){
        int[] bestBid = new int[]{-1_000_000_000, 0};

        for (Map.Entry<Integer, Integer> ask : orderBook.get("bid").entrySet()){
            if (ask.getKey() > bestBid[0] && ask.getValue() > 0)
                bestBid = new int[]{ask.getKey(), ask.getValue()};
        }

        return bestBid;
    }

    void printBestAsk() throws IOException {
        int[] bestAsk = getBestAsk();
        Main.fWrite(bestAsk[0] + "," + bestAsk[1]);
//            System.out.println(bestAsk[0] + "," + bestAsk[1]);
    }

    void printBestBid() throws IOException {
        int[] bestBid = getBestBid();
        Main.fWrite(bestBid[0] + "," + bestBid[1]);
//            System.out.println(bestBid[0] + "," + bestBid[1]);
    }

    void getSizeOfPrice(String priceStr) throws IOException {
        int price = Integer.parseInt(priceStr);

        if (orderBook.get("ask").containsKey(price))
            Main.fWrite(orderBook.get("ask").get(price));
        else if (orderBook.get("bid").containsKey(price))
            Main.fWrite(orderBook.get("bid").get(price));
        else
            Main.fWrite(0);
    }

    int getSizeOf(String type){
        int size = 0;
        for (Map.Entry<Integer, Integer> entry: orderBook.get(type).entrySet()){
            size += entry.getValue();
        }

        return size;
    }
}
