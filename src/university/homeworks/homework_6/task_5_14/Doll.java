<<<<<<< HEAD
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
=======
package homework_6.task_5_14;

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
>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518
