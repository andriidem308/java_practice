package topic_5_OOP.task_1;

public class Flower extends Item{
    int freshness;  // 1 - 100
    double flen;

    Flower(){}
    Flower(String name, double price, int freshness, double flen){
        this.name = name;
        this.price = price;
        this.freshness = freshness;
        this.flen = flen;
    }

    @Override
    public String toString() {
        return name + ": { price: " + price + " UAH, freshness: "
                + freshness + "%, length: " + flen + "cm }";
    }
}
