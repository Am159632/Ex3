//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    }

    //1
    public static int[][] Q1(int n, int m) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 || j == 0)
                    arr[i][j] = 1;
                else
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr;
    }

    //2
    public static String q2(String str) {
        if (str.isEmpty() || str == null)
            return null;
        if (str.length() == 1)
            return str;
        if (str.charAt(0) == str.charAt(1))
            return q2(str.substring(1));
        return str.charAt(0) + q2(str.substring(1));
    }

    //3
    public static int Q5(String s1, String s2) {
        int count = 0;
        boolean ok = true;
        if (s1.isEmpty() || s1 == null || s2.isEmpty() || s2 == null)
            return 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                for (int j = 1; j < s2.length(); j++) {
                    if (s1.charAt(i + j) != s2.charAt(j))
                        ok = false;
                }
                if (ok)
                    count++;
            }
        }
        return count;
    }
    //15,16
    interface Parabula {
        double f(double x); // computes the value of this parabula at x.

        Parabula add(Parabula p); // computes a new Parabula = p + “this”.

        double[] get(); // retunrs an array of doubles {a,b,c}: ax^2+bx+c=0;

        double extream(Parabula p); // returns the x value of the extrema point
        //(min or max), if none throws an Exception
    }
    public class F2 implements Parabula{
        private double a;
        private double b;
        private double c;

        public F2(double a,double b,double c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
        @Override
        public double f(double x){
            return this.a*Math.pow(x,2)+this.b*x+this.c;
        }

        @Override
        public Parabula add(Parabula p) {
            return new F2(this.a+=p.get()[0], this.a+=p.get()[0], this.a+=p.get()[0]);
        }

        @Override
        public double[] get() {
            return new double[]{this.a,this.b,this.c};
        }

        @Override
        public double extream(Parabula p) {
            try{
                return -p.get()[1]/(2*p.get()[0]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

         private static int numberOfRealRoots(Parabula p) {
            int count=0;
            if (p.extream(p))

            return count;
         }

    }

}