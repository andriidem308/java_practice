<<<<<<< HEAD
import java.util.ArrayList;

public class Main {
    public static ArrayList<Toy> createToys() {
        ArrayList<Toy> allToys = new ArrayList<>();

        allToys.add(new Car("Toyota", "Camry", "Black", "Middle", 15));
        allToys.add(new Car("Mercedes", "GL350", "Gray", "Middle", 21));
        allToys.add(new Car("Audi", "A8", "Black", "Small", 11));
        allToys.add(new Car("BMW", "M6", "Blue", "Small", 16));
        allToys.add(new Car("BMW", "X5", "Red", "Big", 19));

        allToys.add(new Doll("Barbie" , "Middle", 11));
        allToys.add(new Doll("Elsa" , "Middle", 12));
        allToys.add(new Doll("Barbie" , "Big", 15));
        allToys.add(new Doll("Diana" , "Big", 14));
        allToys.add(new Doll("Ann" , "Small", 15));

        allToys.add(new Ball("Yellow", "Big", 16));
        allToys.add(new Ball("Blue", "Big", 19));
        allToys.add(new Ball("Red", "Middle", 13));
        allToys.add(new Ball("Blue", "Small", 11));
        allToys.add(new Ball("Green", "Small", 9));

        allToys.add(new Cubes("Basic", "Big", 9));
        allToys.add(new Cubes("Letters", "Small", 7));
        allToys.add(new Cubes("Letters", "Middle", 6));
        allToys.add(new Cubes("Basic", "Middle", 10));
        allToys.add(new Cubes("Basic", "Small", 8));

        return allToys;
    }

    public static void printElements(ArrayList<Toy> elements){
        for (Toy element: elements){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        GameRoom smallGameRoom = new GameRoom("Small", 70, 7);
        GameRoom middleGameRoom = new GameRoom("Middle", 95, 7);
        GameRoom bigGameRoom = new GameRoom("Big", 90, 5);

        ArrayList<Toy> toysMarket = createToys();
        smallGameRoom.buyToys(toysMarket);
        middleGameRoom.buyToys(toysMarket);
        bigGameRoom.buyToys(toysMarket);
        System.out.println(smallGameRoom);
        System.out.println(middleGameRoom);
        System.out.println(bigGameRoom);

        bigGameRoom.sortToys();
        System.out.println("\n\tbigGameRoom sorted: ");
        System.out.println(bigGameRoom);
    }
}
=======
package homework_6.task_5_14;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Toy> createToys() {
        ArrayList<Toy> allToys = new ArrayList<>();

        allToys.add(new Car("Toyota", "Camry", "Black", "Middle", 15));
        allToys.add(new Car("Mercedes", "GL350", "Gray", "Middle", 21));
        allToys.add(new Car("Audi", "A8", "Black", "Small", 11));
        allToys.add(new Car("BMW", "M6", "Blue", "Small", 16));
        allToys.add(new Car("BMW", "X5", "Red", "Big", 19));

        allToys.add(new Doll("Barbie" , "Middle", 11));
        allToys.add(new Doll("Elsa" , "Middle", 12));
        allToys.add(new Doll("Barbie" , "Big", 15));
        allToys.add(new Doll("Diana" , "Big", 14));
        allToys.add(new Doll("Ann" , "Small", 15));

        allToys.add(new Ball("Yellow", "Big", 16));
        allToys.add(new Ball("Blue", "Big", 19));
        allToys.add(new Ball("Red", "Middle", 13));
        allToys.add(new Ball("Blue", "Small", 11));
        allToys.add(new Ball("Green", "Small", 9));

        allToys.add(new Cubes("Basic", "Big", 9));
        allToys.add(new Cubes("Letters", "Small", 7));
        allToys.add(new Cubes("Letters", "Middle", 6));
        allToys.add(new Cubes("Basic", "Middle", 10));
        allToys.add(new Cubes("Basic", "Small", 8));

        return allToys;
    }

    public static void printElements(ArrayList<Toy> elements){
        for (Toy element: elements){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        GameRoom smallGameRoom = new GameRoom("Small", 70, 7);
        GameRoom middleGameRoom = new GameRoom("Middle", 95, 7);
        GameRoom bigGameRoom = new GameRoom("Big", 90, 5);

        ArrayList<Toy> toysMarket = createToys();
        smallGameRoom.buyToys(toysMarket);
        middleGameRoom.buyToys(toysMarket);
        bigGameRoom.buyToys(toysMarket);
        System.out.println(smallGameRoom);
        System.out.println(middleGameRoom);
        System.out.println(bigGameRoom);

        bigGameRoom.sortToys();
        System.out.println("\n\tbigGameRoom sorted: ");
        System.out.println(bigGameRoom);
    }
}
>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518
