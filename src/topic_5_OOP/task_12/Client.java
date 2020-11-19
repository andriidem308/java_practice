package topic_5_OOP.task_12;

public class Client {
    String name, surname;
    String phoneNumber;
    Tariff tariff;

    Client(){};
    Client(String name, String surname, String phoneNumber, Tariff tariff) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.tariff = tariff;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


}
