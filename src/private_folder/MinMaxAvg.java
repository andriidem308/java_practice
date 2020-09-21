package private_folder;

public class MinMaxAvg {
    public static void main(String[] args) {
        int[] array = new int[20];
        for (int i=0; i<20; i++){
            array[i] = 1+ (int) (Math.random() * 50 );
        }

        for (int i=0; i<20; i++){
            System.out.print(array[i] + " ");
        }

        int min=array[0], max=array[0];
        double avg=0;

        for (int i=0; i<20; i++){
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
            avg += array[i];
        }

        System.out.println("\nMin: " + min);
        System.out.println("Max: " + max);
        System.out.println("Avg: " + avg/20);

    }
}
