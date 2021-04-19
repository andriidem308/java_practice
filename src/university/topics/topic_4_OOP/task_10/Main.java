package topic_4_OOP.task_10;

public class Main {
    public static void main(String[] args) {
        Puppy barbos = new Puppy("Barbos", 1, "mixed", "terrier");

        System.out.println(barbos);
        System.out.println("Age: " + barbos.getAge());
        System.out.println("Color: " + barbos.getColor());
        System.out.println("Breed: " + barbos.getBreed());
        barbos.Run();
        barbos.Bit();
        barbos.Bark();
        barbos.Jump();

        Dog someDog = new Dog(5, "black", "german");
        System.out.println("\n" + someDog);
        System.out.println("Age: " + someDog.getAge());
        System.out.println("Color: " + someDog.getColor());
        System.out.println("Breed: " + someDog.getBreed());
        someDog.Run();
        someDog.Bit();
        someDog.Bark();
        someDog.Jump();
    }
}
