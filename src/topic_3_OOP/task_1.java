package topic_3_OOP;

/*
 *  Визначити клас Поліном c коефіцієнтами типу РаціональнийДріб.
 *  Оголосити масив / список / множину із n полиномов і знайдить суму поліномів масиву.
 */

import java.util.Scanner;

public class task_1 {
    public static class Polynomial {
        private double[] coefficients;
        private int size;

        Polynomial(){}

        Polynomial(int size){
            coefficients = new double[size];
            this.size = size;
        }

        Polynomial(Double... argsArray) {
            size = argsArray.length;
            coefficients = new double[size];

            for (int i = 0; i < size; i++){
                coefficients[i] = argsArray[size - 1 - i];
            }
        }

        public void consoleInput(){
            Scanner scanner = new Scanner(System.in);
            String[] strCoeffsArr = scanner.nextLine().split(" ");
            size = strCoeffsArr.length;
            coefficients = new double[size];

            for (int i = 0; i < size; i++){
                coefficients[i] = Double.parseDouble(strCoeffsArr[size-1-i]);
            }
        }

        public double calc(double x){
            double result = 0;

            for (int i = 0; i < size; i++)
                result += coefficients[i] * Math.pow(x, i);

            return result;
        }

        @Override
        public String toString() {
            String out = "";

            for (int i = size-1; i >= 0; i--) {
                if (coefficients[i] == 0.0) continue;
                if (coefficients[i] < 0.0 && !out.isEmpty()){
                    out = out.substring(0, out.length()-2) + "- ";
                }
                if (out.isEmpty()) out += "-";
                out += Math.abs(coefficients[i]) + "x^" + i + " + ";
            }

            out = out.substring(0, out.length() - 3);

            return out;
        }

        public static Polynomial add(Polynomial p1, Polynomial p2){
            int len_1 = p1.size, len_2 = p2.size;
            int max_len = Math.max(len_1, len_2);

            Polynomial new_poly = new Polynomial(max_len);
            for (int i = 0; i < max_len; i++){
                if (i < p1.size) new_poly.coefficients[i] += p1.coefficients[i];
                if (i < p2.size) new_poly.coefficients[i] += p2.coefficients[i];
            }

            return new_poly;
        }
    }

    public static Polynomial sumPolys(Polynomial[] polynomials){
        int polysAmount = polynomials.length;

        if (polysAmount < 2) return new Polynomial();
        Polynomial summaryPoly = Polynomial.add(polynomials[0], polynomials[1]);
        if (polysAmount == 2) return summaryPoly;

        for (int i = 2; i < polysAmount; i++){
            summaryPoly = Polynomial.add(summaryPoly, polynomials[i]);
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
        Polynomial[] polynomials = new Polynomial[6];
        polynomials[0] = new Polynomial(3.0, 4.0, 1.0, 2.0, -3.0, 0.0);
        polynomials[1] = new Polynomial(4.0, 6.0, 5.0, 0.0, -1.0, 1.0, -2.0, 8.0);
        polynomials[2] = new Polynomial(-2.0, -3.0, 0.0, 0.0, -4.0, 9.0, -3.0);
        polynomials[3] = new Polynomial(-3.0, 1.0, 1.0);
        polynomials[4] = new Polynomial(-2.0, 5.0, 0.0, 2.0, 2.0);
        polynomials[5] = new Polynomial(4.0, 4.0, 5.0, 2.0, 5.0, -4.0, 7.0, 8.0);

        return polynomials;
    }

    public static Polynomial[] consoleMode(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Polynomial[] polynomials = new Polynomial[n];

        for (int i = 0; i < n; i++){
            polynomials[i] = new Polynomial();
            polynomials[i].consoleInput();
        }

        return polynomials;
    }

    public static void testCalculating(){
        System.out.println("--- --- --- --- --- TEST CALCULATING --- --- --- --- ---");

        Polynomial poly = new Polynomial(1.0, 3.0, -1.0, 11.0);
        System.out.println(poly);
        System.out.println("x = 2: " + poly.calc(2.0));
        System.out.println("x = -4: " + poly.calc(-4.0));

        System.out.println("\n-------------------------------------------------------");
    }

    public static void testPolysAddition(){
        System.out.println("--- --- --- --- --- TEST ADDITION --- --- --- --- ---");

        Polynomial poly_1 = new Polynomial(2.0, 7.0, -1.0, -3.0, 0.0, 2.0, -4.0);
        Polynomial poly_2 = new Polynomial(3.0, 8.0, 0.0, -6.0, 1.0);
        Polynomial poly_3 = new Polynomial(-5.0, 11.0, 5.0, 5.5, 2.2, 0.0, -6.0, 1.0);

        System.out.println("Polynomial 1: " + poly_1);
        System.out.println("Polynomial 2: " + poly_2);
        System.out.println("Polynomial 3: " + poly_3);

        System.out.println("\nP1 + P2: " + Polynomial.add(poly_1, poly_2));
        System.out.println("P2 + P3: " + Polynomial.add(poly_2, poly_3));
        System.out.println("P3 + P1: " + Polynomial.add(poly_3, poly_1));

        System.out.println("\n-------------------------------------------------------");
    }

    public static void mainTest(){
        System.out.println("--- --- --- --- --- MAIN TEST --- --- --- --- ---");

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n*** ChooseMode ***\n\t0 - Console Mode\n\tOther numbers - Auto Mode\nYour choice: ");
        int mode = scanner.nextInt();

        Polynomial[] polynomials = (mode == 0) ? consoleMode() : autoMode();
        printArray(polynomials);

        Polynomial summaryPolynomial = sumPolys(polynomials);
        System.out.println(summaryPolynomial);

        System.out.println("\n-------------------------------------------------------");
    }

    public static void main(String[] args) {
        testCalculating();
        testPolysAddition();
        mainTest();
    }
}
