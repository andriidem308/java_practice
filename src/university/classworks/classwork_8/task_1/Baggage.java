package university.classworks.classwork_8.task_1;

public class Baggage {
    int id, amount, weight;

    Baggage(int id, int amount, int weight){
        this.id = id;
        this.amount = amount;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Baggage: " + id + "\nAmount: " + amount + "\nWeight: " + weight + "\n";
    }
}
