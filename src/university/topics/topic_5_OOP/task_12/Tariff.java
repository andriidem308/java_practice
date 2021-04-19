package topic_5_OOP.task_12;

import java.util.ArrayList;

public class Tariff {
    String tariffName;
    int price;
    int freeSMS, freeCalls, internetMB, foreignCalls;
    ArrayList<String> clients;

    Tariff(){};
    Tariff(String tariffName, int price,
           int freeSMS, int freeCalls, int internetMB, int foreignCalls,
           ArrayList<String> clients){
        this.tariffName = tariffName;
        this.price = price;
        this.freeSMS = freeSMS;
        this.freeCalls = freeCalls;
        this.internetMB = internetMB;
        this.foreignCalls = foreignCalls;
        this.clients = clients;
    }

    int getClientsAmount(){
        return clients.size();
    }

    @Override
    public String toString(){
        return tariffName + ": " + price + "UAH;";
    }

}
