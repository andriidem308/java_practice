package topic_1_OOP;

import java.util.ArrayList;
import java.util.Date;

public class task_12 {
    public static Date stringToDate(String strDate){
        Date standardDate = new Date(2020, 0, 1, 0, 0, 0);
        Date date = (Date) standardDate.clone();
        String[] timeArray = strDate.split(":");
        date.setHours(Integer.parseInt(timeArray[0]));
        date.setMinutes(Integer.parseInt(timeArray[1]));

        return date;
    }

    public static class Airline{
        String destination, flightNumber, planeType;
        Date departureTime;
        String weekday;

        public Airline(){
            destination = "";
            flightNumber = "";
            planeType = "";
            departureTime = stringToDate("00:00");
            weekday = "";
        }

        public Airline(String destination, String flightNumber, String planeType,
                       String departureTime, String weekday){
            // departureTime format: hh:mm:ss;
            this.destination = destination;
            this.flightNumber = flightNumber;
            this.planeType = planeType;
            this.departureTime = stringToDate(departureTime);
            this.weekday = weekday;
        }

        public String getDestination() {
            return destination;
        }

        public String getFlightNumber() {
            return flightNumber;
        }

        public String getPlaneType() {
            return planeType;
        }

        public Date getDepartureTime() {
            return departureTime;
        }

        public String getWeekday() {
            return weekday;
        }

        public void setDepartureTime(Date departureTime) {
            this.departureTime = departureTime;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public void setFlightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
        }

        public void setPlaneType(String planeType) {
            this.planeType = planeType;
        }

        public void setWeekday(String weekday) {
            this.weekday = weekday;
        }

        @Override
        public String toString() {
            return destination + " " + flightNumber + " " + planeType + ", " +
                    departureTime.getHours() + ":" + departureTime.getMinutes() + " " + weekday;
        }
    }

    public static void test_1(ArrayList<Airline> airlines, String destination){
        System.out.println("--- --- --- --- TEST 1 --- --- --- ---");
        for (Airline airline : airlines){
            if (airline.getDestination().equals(destination)){
                System.out.println(airline);
            }
        }
    }

    public static void test_2(ArrayList<Airline> airlines, String weekday){
        System.out.println("--- --- --- --- TEST 2 --- --- --- ---");
        for (Airline airline : airlines){
            if (airline.getWeekday().equals(weekday)){
                System.out.println(airline);
            }
        }
    }

    public static void test_3(ArrayList<Airline> airlines, String weekday, String time){
        System.out.println("--- --- --- --- TEST 3 --- --- --- ---");
        Date fixedTime = stringToDate(time);

        for (Airline airline : airlines){
            if (airline.getWeekday().compareTo(weekday) == 0 &&
                    airline.getDepartureTime().getTime() > fixedTime.getTime()){
                System.out.println(airline);
            }
        }

    }

    public static void main(String[] args) {
        Airline airline_1 = new Airline("Tokyo", "125T", "T1",
                "12:25", "Tue");
        Airline airline_2 = new Airline("Kyiv", "101K", "T2",
                "11:10", "Wed");
        Airline airline_3 = new Airline("London", "276L", "T3",
                "04:43", "Sat");
        Airline airline_4 = new Airline("Madrid", "500M", "T1",
                "18:50", "Wed");
        Airline airline_5 = new Airline("Tokyo", "151T", "T1",
                "14:15", "Wed");
        Airline airline_6 = new Airline("Tokyo", "80T", "T3",
                "21:30", "Sat");
        Airline airline_7 = new Airline("Minsk", "248M", "T3",
                "06:55", "Wed");
        Airline airline_8 = new Airline("Minsk", "301M", "T1",
                "17:45", "Fri");
        Airline airline_9 = new Airline("Kyiv", "96K", "T2",
                "19:50", "Sat");

        ArrayList<Airline> airlines = new ArrayList<>();
        airlines.add(airline_1);
        airlines.add(airline_2);
        airlines.add(airline_3);
        airlines.add(airline_4);
        airlines.add(airline_5);
        airlines.add(airline_6);
        airlines.add(airline_7);
        airlines.add(airline_8);
        airlines.add(airline_9);

        test_1(airlines, "Kyiv");
        test_2(airlines, "Sat");
        test_3(airlines, "Wed", "14:00");

    }
}
