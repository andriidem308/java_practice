package topic_4_OOP.task_10;

public class Dog extends Animal {
    protected String breed;

    Dog(){}

    Dog(int age, String color, String breed) {
        this.age = age;
        this.color = color;
        this.breed = breed;
    }

    String getBreed(){
        return breed;
    }

    @Override
    void Run(){
        System.out.println("Dog is running.");
    }

    void Bark(){
        System.out.println("Dog is barking.");
    }

    void Jump(){
        System.out.println("Dog is jumping.");
    }

    void Bit(){
        System.out.println("Dog is biting.");
    }

    @Override
    public String toString() {
        return "I am Dog.";
    }
}
