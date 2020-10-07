package topic_2_OOP;

import java.util.Scanner;

public class task_2_5 {
    public static class Interval{
        private double left, right;
        private boolean inclLeft, inclRight;

        Interval(){ }

        Interval(double a, double b) {
            if (a == b){
                System.out.println("Input the interval, not the point!!!");
                System.exit(1);
            }

            this.left = (a < b) ? a : b;
            this.right = (a < b) ? b : a;
            this.inclLeft = true;
            this.inclRight = true;
        }

        Interval(double a, double b, boolean inclLeft, boolean inclRight) {
            if (a == b){
                System.out.println("Input the interval, not the point!!!");
                System.exit(1);
            }

            this.left = (a < b) ? a : b;
            this.right = (a < b) ? b : a;
            this.inclLeft = inclLeft;
            this.inclRight = inclRight;
        }

        public Interval getIntersection(Interval other){
            if (this.right < other.left || this.left > other.right){
                return null;
            }

            double left, right;
            boolean leftIncluded, rightIncluded;

            if (this.left > other.left){
                left = this.left;
                leftIncluded = this.inclLeft;
            } else {
                left = other.left;
                leftIncluded = other.inclLeft;
            }

            if (this.right < other.right){
                right = this.right;
                rightIncluded = this.inclRight;
            } else {
                right = other.right;
                rightIncluded = other.inclRight;
            }

            return new Interval(left, right, leftIncluded, rightIncluded);
        }

        public Interval getUnion(Interval other){
            if (this.right < other.left || this.left > other.right){
                return null;
            }

            double left, right;
            boolean leftIncluded, rightIncluded;

            if (this.left < other.left){
                left = this.left;
                leftIncluded = this.inclLeft;
            } else {
                left = other.left;
                leftIncluded = other.inclLeft;
            }

            if (this.right > other.right){
                right = this.right;
                rightIncluded = this.inclRight;
            } else {
                right = other.right;
                rightIncluded = other.inclRight;
            }

            return new Interval(left, right, leftIncluded, rightIncluded);
        }

        @Override
        public String toString() {
            String result = "";
            if (inclLeft) result += "[";
            result += left + ", " + right;
            if (inclRight) result += "]";

            return result;
        }
    }

    public static Interval findLargest(Interval[] intervals){
        double left = intervals[0].left;
        double right = intervals[0].right;

        for (int i = 1; i < intervals.length; i++){
            if (intervals[i].left < left){
                left = intervals[i].left;
            }
            if (intervals[i].right > right){
                right = intervals[i].right;
            }
        }

        return new Interval(left, right);
    }

    public static Interval findMax(){
        return new Interval();
    }

    public static void main(String[] args) {
        Interval interval_1 = new Interval(0, 4);
        Interval interval_2 = new Interval(-10, 2);
        System.out.println(interval_1.getIntersection(interval_2));

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Interval[] intervals = new Interval[n];

        for (int i = 0; i < n; i++){
            String[] strInterval = scanner.nextLine().split(" ");
            double a, b;
            boolean ai = true, bi = true;

            a = Double.parseDouble(strInterval[0]);
            b = Double.parseDouble(strInterval[1]);

            if (strInterval.length == 4){
                ai = strInterval[2].equals("1");
                bi = strInterval[3].equals("1");
            }

            intervals[i] = new Interval(a, b, ai, bi);
        }

        Interval largestInterval = findLargest(intervals);
        System.out.println(largestInterval);
    }
}
