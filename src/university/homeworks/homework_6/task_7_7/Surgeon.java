package homework_6.task_7_7;

public class Surgeon implements Doctor {
    String name;
    String surname;
    int age;
    int expYears;

    Surgeon(String name, String surname, int age, int expYears){
        this.name = name;
        this.age = age;
        this.expYears = expYears;
    }

    @Override
    public void diagnose() {
        System.out.println("Diagnosing...");
    }

    @Override
    public void treatPatient(){
        System.out.println("Treating...");
    }

    public void operate(){
        System.out.println("Operating...");
    }

    @Override
    public String toString() {
        return "Surgeon " + name + " " + surname;
    }
}
