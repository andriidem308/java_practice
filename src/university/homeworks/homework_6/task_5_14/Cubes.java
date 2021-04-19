public class Cubes extends Toy {
    String type;  // solid or with letters

    Cubes(String type, String size, int price) {
        super(size, price);
        this.type = type;
    }


    @Override
    public String toString() {
        return "* Cubes " +
                "\nType: " + type +
                "\n" + super.toString();
    }
}
