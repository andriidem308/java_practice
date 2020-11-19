package ann;

public class LinearRoot extends Root{
    // bx + c = 0
    double b, c;


    LinearRoot(double b, double c){
        this.b = b;
        this.c = c;
        this.root = getRoot();
    }

    @Override
    String getRoot(){
        String root;
        if (b == 0 && c != 0) root = null;
        else if (b == 0 && c == 0) root = "INFINITY AMOUNT";
        else root = "" + (-c / b);

        return root;
    }

    @Override
    boolean hasRoot() {
        return (root != null);
    }

    @Override
    public String toString() {
        return "root = " + this.root;
    }
}
