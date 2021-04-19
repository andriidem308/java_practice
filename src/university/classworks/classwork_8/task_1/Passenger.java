package university.classworks.classwork_8.task_1;

import java.io.Serializable;

public class Passenger implements Serializable {
    String surname;
    int id;

    Passenger(String surname, int id){
        this.surname = surname;
        this.id = id;
    }
}
