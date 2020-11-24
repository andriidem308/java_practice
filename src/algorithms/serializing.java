package algorithms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class serializing {
    public static void main(String[] args) {
        String filename = "filename.dat";
        Object obj = new Object();

        // --- SERIALIZING ---
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
            System.out.println("SERIALIZED");
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        // --- DESERIALIZING ---
        Object dsObj;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            dsObj = ((Object) ois.readObject());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
