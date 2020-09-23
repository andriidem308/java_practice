package classwork_2;

public class task_4_7 {
    public static double expTailor(double x){
        double eps = 0.00001;
        double result = 1, a = 1;
        int i = 1;

        while (a > eps){
            a *= x / i;
            result += a;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        double x = 3.27;
        System.out.println(expTailor(x));
        System.out.println(Math.exp(x));
    }
}
