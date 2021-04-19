package classwork_4;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.spi.AbstractResourceBundleProvider;

public class task_1 {
    public static class Student {
        private int id;
        private String firstName, middleName, lastName;
        private String dateOfBirth, address, phoneNumber;
        private String faculty, groupName;
        private int gradeYear;

        public Student(int id, String lastName, String firstName, String middleName,
                       String dateOfBirth, String address, String phoneNumber,
                       String faculty, int gradeYear, String groupName){
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleName;
            this.dateOfBirth = dateOfBirth;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.faculty = faculty;
            this.gradeYear = gradeYear;
            this.groupName = groupName;
        }

        public Student() {
            this.id = 0;
            this.lastName = null;
            this.firstName = null;
            this.middleName = null;
            this.dateOfBirth = null;
            this.address = null;
            this.phoneNumber = null;
            this.faculty = null;
            this.gradeYear = 0;
            this.groupName = null;
        }

        public Student(int id, String lastName, String firstName, String middleName) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleName;
            this.dateOfBirth = null;
            this.address = null;
            this.phoneNumber = null;
            this.faculty = null;
            this.gradeYear = 0;
            this.groupName = null;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public int getId() {
            return id;
        }

        public int getGradeYear() {
            return gradeYear;
        }

        public String getAddress() {
            return address;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public int getYearFromString() {
            String dateArr[] = getDateOfBirth().split("\\.");
            return Integer.parseInt(dateArr[2]);
        }

        public String getFaculty() {
            return faculty;
        }

        public String getGroupName() {
            return groupName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public void setFaculty(String faculty) {
            this.faculty = faculty;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setGradeYear(int gradeYear) {
            this.gradeYear = gradeYear;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getFullName(){
            String fullName = "";
            fullName += getId() + ". " + getLastName() + " " + getFirstName() + " " + getMiddleName();
            fullName += ". Group: " + getGroupName() + ", Year: " + getGradeYear();
            return fullName;
         }

        public String toString(){
            String info = "";
            info += "Student id: " + getId() + "\n";
            info += getLastName() + " " + getFirstName() + " " + getMiddleName() + "\n";
            info += "Date of birth: " + getDateOfBirth() + "\n";
            info += "Address: " + getAddress() + "\n";
            info += "Phone: " + getPhoneNumber() + "\n";
            info += "Faculty: " + getFaculty() + ", Year: " + getGradeYear() + ", Group: " + getGroupName();

            return info;
        }
    }

    public static void test_1(ArrayList<Student> students, String facultyName){
        System.out.println("\n--- --- --- --- TEST 1 --- --- --- ---");
        for (Student student: students){
            if (student.getFaculty().equals(facultyName)){
                System.out.println(student.getFullName());
            }
        }
    }

    public static void test_2(ArrayList<Student> students, int gradeYear){
        System.out.println("\n--- --- --- --- TEST 2 --- --- --- ---");
        Map<String, ArrayList<Student>> mapStudents = new HashMap<>();

        for (Student student: students){
            if (student.getGradeYear() == gradeYear){
                String facultyName = student.getFaculty();

                if (!(mapStudents.containsKey(facultyName))){
                    ArrayList<Student> fStudents = new ArrayList<>();
                    mapStudents.put(facultyName, fStudents);
                }

                mapStudents.get(facultyName).add(student);
            }
        }

        for (Map.Entry<String, ArrayList<Student>> pair: mapStudents.entrySet()){
            System.out.println("*** Faculty: " + pair.getKey() + " ***");
            for (Student student: pair.getValue()){
                System.out.println(student.getFullName());
            }
            System.out.println();
        }
    }

    public static void test_3(ArrayList<Student> students, int year){
        System.out.println("\n--- --- --- --- TEST 3 --- --- --- ---");
        System.out.println("*** Students born after " + year + "-th year (included) ***");
        for (Student student: students){
            int birthYear = student.getYearFromString();
            if (birthYear >= year){
                System.out.println(student.getFullName() + "; Birth year: " + birthYear);
            }
        }
    }

    public static void test_4(ArrayList<Student> students, String facultyName, String groupName){
        System.out.println("\n--- --- --- --- TEST 4 --- --- --- ---");
        System.out.println("*** Students of group " + groupName + " at faculty " + facultyName + " ***");
        for (Student student: students){
            if (student.getFaculty().equals(facultyName) && student.getGroupName().equals(groupName)){
                System.out.println(student.getFullName());
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        Student student_1 = new Student(1, "Demchenko", "Andrii", "Andriyovych",
                "30.08.2001", "Lomonosova, 47", "380661231322",
                "MM", 3, "CM");
        Student student_2 = new Student(2, "Nikiforov", "Olexandr", "Olexandrovych",
                "18.07.2001", "Lomonosova, 47", "380662220102",
                "MM", 3, "CM");
        Student student_3 = new Student(13, "Petrov", "Petro", "Petrovych",
                "20.02.2002", "str S, 1", "123123123",
                "AA", 2, "AM");
        Student student_4 = new Student(21, "A", "B", "C",
                "20.02.2000", "str S, 1", "123123100",
                "AA", 3, "CM");
        Student student_5 = new Student(44, "A", "D", "E",
                "20.02.2000", "str S, 1", "123123111",
                "AA", 3, "AM");
        Student student_6 = new Student(14, "C", "H", "K",
                "20.02.2000", "str S, 1", "123123133",
                "BB", 4, "BA");
        Student student_7 = new Student(12, "L", "M", "M",
                "20.02.1999", "str S, 1", "123123144",
                "CC", 2, "CM");
        Student student_8 = new Student(3, "V", "V", "R",
                "20.02.2002", "str S, 1", "123123155",
                "MM", 1, "M");
        Student student_9 = new Student(6, "O", "T", "R",
                "20.02.2001", "str S, 1", "123123166",
                "CC", 3, "CM");

        students.add(student_1);
        students.add(student_2);
        students.add(student_3);
        students.add(student_4);
        students.add(student_5);
        students.add(student_6);
        students.add(student_7);
        students.add(student_8);
        students.add(student_9);

        test_1(students, "MM");
        test_2(students, 3);
        test_3(students, 2001);
        test_4(students, "MM", "CM");

    }
}
