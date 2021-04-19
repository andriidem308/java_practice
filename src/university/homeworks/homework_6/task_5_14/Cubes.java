<<<<<<< HEAD
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
=======
package homework_6.task_5_14;

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
>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518
