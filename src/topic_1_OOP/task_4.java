package topic_1_OOP;

import java.util.ArrayList;

//OOP task4(Не знайшов де знаходяться номера дз тому взяв номер  з формули <номер в списку>%<кількість задач>)

public class task_4 {
    public static class Abiturient{
        int id;
        String name;
        String surname;
        String fathers;
        String birthday;
        String adress;
        String telephone;
        String marks;
        ArrayList<Double> marksArray;

        public Abiturient(int id,String name,String surname,String fathers,String birthday,String adress,String telephone,String marks){
            this.id=id;
            this.name=name;
            this.surname=surname;
            this.fathers=fathers;
            this.birthday=birthday;
            this.adress=adress;
            this.telephone=telephone;
            this.marks=marks;
            String[] strMarks = marks.split(" ");
            this.marksArray = new ArrayList<>();
            for (int i = 0; i < strMarks.length; i++){
                marksArray.add(Double.parseDouble(strMarks[i]));
            }
        }

        public Abiturient(){

        }

        public String getName(){
            return name;
        }

        public String getSurname(){
            return surname;
        }

        public String getFathers(){
            return fathers;
        }

        public String getAdress(){
            return adress;
        }

        public String getTelephone(){
            return telephone;
        }

        public int getId(){
            return id;
        }

        public String  getMarks(){
            return marks;
        }

        public String getBirthday() {
            return birthday;
        }

        public int getYearFromString() {
            String[] dateArr = getBirthday().split("\\.");
            return Integer.parseInt(dateArr[2]);
        }

        public int getDayFromString() {
            String[] dateArr = getBirthday().split("\\.");
            return Integer.parseInt(dateArr[0]);
        }

        public int getMonthFromString() {
            String[] dateArr = getBirthday().split("\\.");
            return Integer.parseInt(dateArr[1]);
        }

        public void setId(int newid){
            this.id = newid;
        }

        public void setName(String newname){
            this.name=newname;
        }

        public void setSurname(String newsurname){
            this.surname=newsurname;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public void setFathers(String fathers){
            this.fathers=fathers;
        }

        public void setBirthday(String birthday){
            this.birthday=birthday;
        }

        public void setTelephone(String telephone){
            this.telephone=telephone;
        }

        public void setMarks(String marks){
            this.marks=marks;
        }

        public void getMarkstoList(){
            String[] marksarr = getMarks().split(" ");
            for(int i = 0; i < marksarr.length;i++){
                marksArray.add(Double.parseDouble(marksarr[i]));
            }
        }

        public double AvarageMark(){
            double avarage = 0;
            for(Double mark : marksArray){
                avarage += mark;
            }
            avarage/= marksArray.size();
            return avarage;
        }

        public String toString(){
            String info = "";
//            String info = "Student ID" +  getId()+"\n";
            info+= getSurname()+" "+ getName()+" "+getFathers()+", ";
//            info+="Birthday: day "+ getDayFromString()+", month "+getMonthFromString()+", year "+getYearFromString()+"\n";
//            info +="Adress "+ getAdress()+", telephone "+getTelephone()+"\n";
            info+="Average mark "+AvarageMark();
            return info;
        }

        public void CheckAvarage(double n){
            if(AvarageMark()<n){
                System.out.println(toString());
            }
        }

        public void CheckMarks(){
            for(Double mark : marksArray){
                if(mark<=2){
                    System.out.println(toString());
                    break;
                }
            }
        }
    }

    public static double strToDouble(String s){
        String[] arrStr = s.split(" ");
        double res = Double.parseDouble(arrStr[arrStr.length - 1]);
        return res;
    }


    public static void insertionSort(String[] array){
        int size = array.length;
        int i, j;
        String itemToInsert;

        for (i = 1; i < size; i++){
            itemToInsert = array[i];
            double a = strToDouble(itemToInsert);
            j = i - 1;

            while (j >= 0 && strToDouble(array[j]) < a){
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = itemToInsert;
        }
    }

    public static void sortAbiturients(Abiturient[] abiturients, int n){
        String[] sorted = new String[abiturients.length];
        for (int i = 0; i < abiturients.length; i++){
            sorted[i] = abiturients[i].toString();
        }

        insertionSort(sorted);
        System.out.println();
        for (int i = 0; i < n; i++){
            System.out.println(sorted[i]);
        }
    }

    public static void main(String[] args) {
        Abiturient[] abiturients = new Abiturient[6];
        abiturients[0] = new Abiturient(344445,"Kiril", "Mitroshin","Ivanovich","12.3.2002","Kilova22","3809999","3 2 3 2 2");
        abiturients[1] = new Abiturient(346745,"Dima", "Kil","Ivanovich","13.4.2001","Iva2","3888999","5 5 5 5 5");
        abiturients[2] = new Abiturient(348845,"Katya", "Nilya","Ivanovna","14.8.2001","Lik5","380095","5 4 5 5 5");
        abiturients[3] = new Abiturient(444445,"Mitya", "Danilov","Maximovich","14.5.2002","Pol7","355999","4 3 4 2 5");
        abiturients[4] = new Abiturient(348845,"Katya", "Ksiva","Kirilovna","14.6.2001","Lik5","380095","5 4 4 4 4");
        abiturients[5] = new Abiturient(348945,"Ira", "Mitina","Aleksandrovna","14.8.2002","Pack5","380085","5 3 3 4 4");

        System.out.println("Abiturients with bad marks: ");
        for(int i = 0;i<6;i++){
            abiturients[i].CheckMarks();
        }
        System.out.println("\nAbiturients with a avarage mark less than 4:");
        for(int i = 0;i<6;i++){
            abiturients[i].CheckAvarage(4);
        }

        int n = 3;
        sortAbiturients(abiturients, n);

    }
}