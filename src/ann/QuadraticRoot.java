package ann;

public class QuadraticRoot extends Root {
    // ax^2 + bx + c = 0
    double a, b, c;

    QuadraticRoot(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
        this.root = getRoot();
    }

    @Override
    String getRoot() {
        String root;

        if (a == 0) {
            LinearRoot lRoot = new LinearRoot(b, c);
            root = lRoot.getRoot();
            return root;
        }

        double d = b*b - 4*a*c;

        if (d < 0) root = null;
        else if (d == 0) {
            root = "" + (-b / 2 / a);
        }
        else {
            root = "" + ((-b - Math.sqrt(d)) / 2 / a);
            root += ", " + ((-b + Math.sqrt(d)) / 2 / a);
        }

        return root;
    }

    @Override
    boolean hasRoot() {
        return (root != null);
    }

    @Override
    public String toString() {
        return "root(s): " + this.root;
    }
}
