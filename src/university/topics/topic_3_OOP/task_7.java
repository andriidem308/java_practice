package topic_3_OOP;

class Fraction{
    int m, n;

    public Fraction(){
        this.m = 0;
        this.n = 1;
    }

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

class Point {
    private Fraction x, y, z;

    public Point(){
        this.x = new Fraction();
        this.y = new Fraction();
        this.z = new Fraction();
    }

    public Point(Fraction x, Fraction y, Fraction z){
        this.x = new Fraction(x.m, x.n);
        this.y = new Fraction(y.m, y.n);
        this.z = new Fraction(z.m, z.n);
    }

    public double getDistance(Point other){
        double x, y, z;
        x = this.x.getValue() - other.x.getValue();
        y = this.y.getValue() - other.y.getValue();
        z = this.z.getValue() - other.z.getValue();

        return Math.sqrt(x*x + y*y + z*z);
    }

    public double getDistanceToCenter(){
        return getDistance(new Point());
    }
}

public class task_7 {
    public static void main(String[] args) {
        Fraction a = new Fraction(4, 3);
        Fraction b = new Fraction(3, 5);
        Fraction c = new Fraction(2, 3);

        System.out.println(new Point(a, b, c).getDistanceToCenter());
    }
}
