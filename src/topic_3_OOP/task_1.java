package topic_3_OOP;

/*
 *  Визначити клас Поліном c коефіцієнтами типу РаціональнийДріб.
 *  Оголосити масив / список / множину із n полиномов і знайдить суму поліномів масиву.
 */

import java.util.Scanner;

public class task_1 {
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

    public static class Polynomial {
        public static int max_len;
        public Fraction[] coefficients;
        private int size;

        Polynomial(){}

        Polynomial(int size){
            this.coefficients = new Fraction[size];
            this.size = size;
            if (size > max_len) max_len = size;
            for (int i = 0; i < size; i++)
                this.coefficients[i] = new Fraction(0, 1);
        }

        Polynomial(Integer... argsArray) {
            size = argsArray.length / 2;

            if (size > max_len) max_len = size;
            coefficients = new Fraction[size];

            for (int i = 0; i < argsArray.length; i+=2){
                int m1, n1;
                m1 = argsArray[i];
                n1 = argsArray[i+1];

                coefficients[size - i/2 - 1] = new Fraction(m1, n1);
            }
        }


        @Override
        public String toString() {
            String out = "";

            for (int i = size-1; i >= 0; i--) {
                if (coefficients[i].m == 0.0) continue;
                out += coefficients[i] + "x^" + i + " + ";
            }

            out = out.substring(0, out.length() - 3);

            return out;
        }

        public static Polynomial add(Polynomial p1, Polynomial p2){
            int len_1 = p1.size, len_2 = p2.size;
            int max_len = Math.max(len_1, len_2);

            Polynomial new_poly = new Polynomial(max_len);

            for (int i = 0; i < max_len; i++){
                if (i < len_1) new_poly.coefficients[i].add(p1.coefficients[i]);
                if (i < len_2) new_poly.coefficients[i].add(p2.coefficients[i]);
            }

            return new_poly;
        }
    }

    public static Polynomial sumPolys(Polynomial[] polynomials){
        Polynomial summaryPoly = new Polynomial(Polynomial.max_len);
        for (Polynomial polynomial : polynomials) {
            summaryPoly = Polynomial.add(summaryPoly, polynomial);
        }

        return summaryPoly;
    }

    public static <T> void printArray(T[] array){
        System.out.println();
        for(T element : array){
            System.out.println(element);
        }
        System.out.println();
    }

    public static Polynomial[] autoMode(){
        Polynomial[] polynomials = new Polynomial[8];
        polynomials[0] = new Polynomial(1, 2, 2, 3, 7, 5);
        polynomials[1] = new Polynomial(3, 4, 5, 3, 1, 5);
        polynomials[2] = new Polynomial(2, 4, 2, 3, 8, 5);
        polynomials[3] = new Polynomial(2, 4, -1, 3, 8, 5);
        polynomials[4] = new Polynomial(-2, 4, 1, 3, 8, 5);
        polynomials[5] = new Polynomial(2, 4, 5, 2, 8, 5);
        polynomials[6] = new Polynomial(2, 4, -1, 3, 8, 5);
        polynomials[7] = new Polynomial(2, 4, 2, 3, 8, 5);

        return polynomials;
    }

    public static void mainTest(){
        Polynomial[] polynomials = autoMode();

        Polynomial summaryPolynomial = sumPolys(polynomials);
        System.out.println(summaryPolynomial);
        System.out.println("-------------------------------------------------------");
    }

    public static void main(String[] args) {
        mainTest();
    }
}
