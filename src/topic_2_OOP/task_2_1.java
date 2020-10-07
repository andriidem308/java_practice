package topic_2_OOP;

import java.util.Scanner;

public class task_2_1 {
    public static class Fraction{
        int m, n;

        public Fraction(int m, int n){
            if (n == 0)
                System.exit(1);
            this.m = m;
            this.n = n;
        }

        public double getValue(){
            return (double) m / n;
        }

        public void add(Fraction other){
            if (this.n == other.n){
                this.m += other.m;
            }
            else {
                int m1 = this.m;
                int n1 = this.n;

                this.m = m1*other.n + other.m*n1;
                this.n = n1 * other.n;
            }

            update();
        }

        public void subtract(Fraction other){
            if (this.n == other.n){
                this.m -= other.m;
            }
            else {
                int m1 = this.m;
                int n1 = this.n;

                this.m = m1*other.n - other.m*n1;
                this.n = n1 * other.n;
            }

            update();
        }

        public void multiply(Fraction other){
            this.m *= other.m;
            this.n *= other.n;

            update();
        }

        public void divide(Fraction other){
            this.m *= other.n;
            this.n *= other.m;

            update();
        }

        public int gcd(){
            int a = m, b = n;

            while (a != b) {
                if (a > b){
                    a -= b;
                } else {
                    b -= a;
                }
            }

            return b;
        }

        public void update(){
            if (m % n == 0){
                this.m = m / n;
                this.n = 1;
            } else if (gcd() > 1){
                int var_gcd = gcd();
                this.m /= var_gcd;
                this.n /= var_gcd;
            }
        }

        @Override
        public String toString() {
            return m + "/" + n;
        }
    }

    public static void addFractions(Fraction[] fractions){
        int size = fractions.length;

        for (int i = 0; i < size - 1; i++){
            fractions[i].add(fractions[i+1]);
        }

        for (int i = 0; i < size; i++){
            System.out.println(fractions[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Fraction f1 = new Fraction(5, 8);
        Fraction f2 = new Fraction(1, 8);
        f1.add(f2);
        System.out.println(f1);

        int k = Integer.parseInt(scanner.nextLine());
        Fraction[] fractions = new Fraction[k];

        for (int i = 0; i < k; i++) {
            String[] line = scanner.nextLine().split(" ");
            int m, n;
            m = Integer.parseInt(line[0]);
            n = Integer.parseInt(line[1]);

            fractions[i] = new Fraction(m, n);
        }

        addFractions(fractions);

    }
}
