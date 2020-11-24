package university.homeworks.homework_9.IntegerSet;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;

public class IntegerSet implements Serializable {
    HashSet<Integer> set;
    transient String fileIn;
    transient String fileOut;

    IntegerSet(HashSet<Integer> other){
        set = new HashSet<>();
        set.addAll(other);
    }

    IntegerSet(String fileIn, String fileOut){
        set = new HashSet<>();
        this.fileIn = fileIn;
        this.fileOut = fileOut;
    }

    void updateSet(HashSet<Integer> updated){
        set.clear();
        set.addAll(updated);
    }

    void inputSet(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileIn))){
            IntegerSet tmpIntegerSet;
            tmpIntegerSet = ((IntegerSet) ois.readObject());
            this.set = new HashSet<>(tmpIntegerSet.set);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    void outputSet(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileOut))){
            IntegerSet tmpIntegerSet = new IntegerSet(set);
            oos.writeObject(tmpIntegerSet);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    void add(Integer x){ set.add(x); }

    void remove(Integer x){ set.remove(x); }

    boolean contains(Integer x){ return set.contains(x); }

    boolean isEmpty(){ return set.isEmpty();}

    Integer getMax(){ return Collections.max(set);}

    Integer getMin(){ return Collections.min(set);}

    HashSet<Integer> intersection(HashSet<Integer> other){
        HashSet<Integer> joinSet = new HashSet<>(set);
        joinSet.addAll(other);
        return joinSet;
    }

    HashSet<Integer> difference(HashSet<Integer> other){
        HashSet<Integer> diffSet = new HashSet<>(set);
        diffSet.removeAll(other);
        return diffSet;
    }

    Integer getWeight(){
        return set.size();
    }

    Integer getDiameter(){
        return getMax() - getMin();
    }

    boolean isSubset(HashSet<Integer> other){
        HashSet<Integer> tmpSet = new HashSet<>();
        tmpSet.addAll(set);
        tmpSet.removeAll(other);

        return tmpSet.isEmpty();
    }

    boolean isEqual(HashSet<Integer> other){
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();

        s1.addAll(set);
        s2.addAll(other);

        s1.removeAll(other);
        s2.removeAll(set);

        return (s1.isEmpty() && s2.isEmpty());
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Integer x: set) out.append(x).append(" ");
        out.append("\n");

        return String.valueOf(out);
    }

    String strSet(){
        String out = "";

        if (set != null) {
            for (Integer x : set) {
                out += x + " ";
            }
        }
        return out;
    }

    void printSet(){
        System.out.println(strSet());
    }


    static String strSomeSet(HashSet<Integer> someSet){
        String out = "";
        for (Integer x: someSet){
            out += x + " ";
        }
        return out;
    }

    static void printSomeSet(HashSet<Integer> someSet){
        System.out.println(strSomeSet(someSet));
    }


    void test(){
        // ==============   Begin test   ==============


        System.out.println("\n___Test input from file___");
        inputSet();
        System.out.println("loaded set: " + strSet());

        // ----------------------------------------------

        System.out.println("\n___Test output to file___");
        outputSet();
        System.out.println("*WRITTEN*");
        System.out.println("Checking:...");
        IntegerSet tstSet;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileOut))){
            tstSet = ((IntegerSet) ois.readObject());

            System.out.println("Initial set: " + strSet());
            System.out.println("Written set: " + tstSet.strSet());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // ----------------------------------------------

        System.out.println("\n___Test addition to the set___");
        System.out.println("BEFORE: " + strSet());
        add(25);
        System.out.println("AFTER: " + strSet());

        // ----------------------------------------------

        System.out.println("\n___Test removing from the set___");
        System.out.println("BEFORE: " + strSet());
        remove(25);
        System.out.println("AFTER: " + strSet());

        // ----------------------------------------------

        System.out.println("\n___Test containing element in the set___");
        printSet();
        System.out.println("Checking element 5: " + contains(5));
        System.out.println("Checking element -6: " + contains(-6));
        System.out.println("Checking element 4: " + contains(4));
        System.out.println("Checking element 19: " + contains(19));

        // ----------------------------------------------

        System.out.println("\n___Test checking if set is empty___");
        printSet();
        System.out.println("Is empty: " + isEmpty());

        // ----------------------------------------------

        System.out.println("\n___Test finding max-element in the set___");
        printSet();
        System.out.println(getMax());

        // ----------------------------------------------

        System.out.println("\n___Test finding min-element in the set___");
        printSet();
        System.out.println(getMin());

        // ----------------------------------------------
        // * Initialize other sets, needed for testing *
        HashSet<Integer> otherSetB = new HashSet<>();
        for (int i = -10; i < 10; i+=2) otherSetB.add(i);

        HashSet<Integer> otherSetC = new HashSet<>();
        otherSetC.addAll(set);
        otherSetC.add(12);
        otherSetC.add(-12);
        otherSetC.add(-17);
        otherSetC.add(6);

        HashSet<Integer> otherSetD = new HashSet<>();
        otherSetD.addAll(set);


        // ----------------------------------------------

        System.out.println("\n___Test sets intersection___");
        System.out.print("set A: " + strSet() + "\nset B: ");
        printSomeSet(otherSetB);
        System.out.print("intersection: ");
        printSomeSet(intersection(otherSetB));

        // ----------------------------------------------

        System.out.println("\n___Test sets difference___");
        System.out.print("set A: " + strSet() + "\nset B: ");
        printSomeSet(otherSetB);
        System.out.print("difference: ");
        printSomeSet(difference(otherSetB));

        // ----------------------------------------------

        System.out.println("\n___Test set weight___");
        System.out.println("weight: " + getWeight());

        // ----------------------------------------------

        System.out.println("\n___Test set diameter___");
        System.out.println("diameter: " + getDiameter());

        // ----------------------------------------------

        System.out.println("\n___Test set A inside other set___");
        System.out.println("set A: " + strSet());
        System.out.println("set B: " + strSomeSet(otherSetB));
        System.out.println("set C: " + strSomeSet(otherSetC));

        System.out.println("\nA is subset B: " + isSubset(otherSetB));
        System.out.println("A is subset C: " + isSubset(otherSetC));

        // ----------------------------------------------

        System.out.println("\n___Test set A equals to other set___");
        System.out.println("set A: " + strSet());
        System.out.println("set B: " + strSomeSet(otherSetB));
        System.out.println("set C: " + strSomeSet(otherSetC));
        System.out.println("set D: " + strSomeSet(otherSetD));

        System.out.println("\nA is equal to B: " + isEqual(otherSetB));
        System.out.println("A is equal to C: " + isEqual(otherSetC));
        System.out.println("A is equal to D: " + isEqual(otherSetD));


        // ===============   End test   ===============
    }
}
