package homework_6.task_7_7;

public class NeuroSurgeon extends Surgeon {
    String category;

    NeuroSurgeon(String name, String surname, int age, int expYears, String category){
        super(name, surname, age, expYears);
        this.category = category;
    }

    @Override
    public void operate(){
        System.out.println("Operating neuro...");
    }

    @Override
    public String toString() {
        return "Neurosurgeon " + name + " " + surname;
    }
}
