public class Doll extends Toy{
    String name;

    Doll(String name, String size, int price) {
        super(size, price);
        this.name = name;
    }


    @Override
    public String toString() {
        return "* Doll" +
                "\nName: " + name +
                "\n" + super.toString();
    }
}
