public abstract class Toy {
    String size;
    int price;

    Toy(String size, int price){
        this.size = size;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Size: " + size +
                "\nPrice: " + price +
                "\n";
    }
}
