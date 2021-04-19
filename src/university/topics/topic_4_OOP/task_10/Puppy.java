package topic_4_OOP.task_10;

public class Puppy extends Dog {
    String name;

    Puppy(String name, int age, String color, String breed){
        super(age, color, breed);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    void Run(){
        System.out.println("Puppy " + name + " is running");
    }

    @Override
    void Bark() {
        System.out.println("Puppy " + name + " is barking, but SOO CUUUTE");
    }

    @Override
    void Jump() {
        System.out.println("Puppy " + name + " is trying to jump");
    }

    @Override
    void Bit() {
        System.out.println("Puppy " + name + " is easily biting");
    }

    @Override
    public String toString() {
        return "I am little puppy, my name is " + name;
    }
}
