<<<<<<< HEAD
public class Ball extends Toy {
    String color;


    Ball(String color, String size, int price) {
        super(size, price);
        this.color = color;
    }

    @Override
    public String toString() {
        return "* Ball" +
                "\nColor: " + color +
                "\n" + super.toString();
    }
}
=======
package homework_6.task_5_14;

public class Ball extends Toy {
    String color;


    Ball(String color, String size, int price) {
        super(size, price);
        this.color = color;
    }

    @Override
    public String toString() {
        return "* Ball" +
                "\nColor: " + color +
                "\n" + super.toString();
    }
}
>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518
