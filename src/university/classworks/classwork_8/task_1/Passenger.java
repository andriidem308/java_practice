package university.classworks.classwork_8.task_1;

import java.io.Serializable;

public class Passenger implements Serializable {
    String surname;
    int id;

    Passenger(String surname, int id){
        this.surname = surname;
        this.id = id;
    }
<<<<<<< HEAD
=======

    public Passenger() {
        this.surname = "";
        this.id = -1;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Surname: %s", id, surname);
    }
>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518
}
