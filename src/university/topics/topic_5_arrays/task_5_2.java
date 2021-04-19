package topic_5_arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class task_5_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<>();

        int n = scanner.nextInt();

        double s = 0.0;
        double sum = 0.0;
        double ssd, mean;

        for (int i = 0; i < n; i++){
            double new_number = scanner.nextDouble();
            numbers.add(new_number);
            s += new_number;
        }

        mean = s / n;
        for (Double x: numbers) sum += Math.pow((x - mean), 2);
        ssd = Math.sqrt(sum / (n-1));

        System.out.println("Mean: " + mean);
        System.out.println("Sample Standard deviation: " + ssd);

    }
}
