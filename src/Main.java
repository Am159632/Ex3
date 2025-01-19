import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("מספר ספניק?");
        int n=sc.nextInt();
        System.out.println(Q6(n));
        int[][] arr = Q1(7, 9);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(q2("aabbbcccxxyaaa"));
        System.out.println(Q3("to be or not to be", "be"));
        System.out.println(Q3("aaa", "aa"));
        double[] maxR = Q7(new double[]{4, 2, 3, 5, 0, 1});
        for (int i = 0; i < maxR.length; i++)
            System.out.println(maxR[i] + " ");
        maxR = Q7(new double[]{3, 2, 1});
        for (int i = 0; i < maxR.length; i++)
            System.out.println(maxR[i] + " ");
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
    public static int Q3(String s1, String s2) {
        int count = 0;
        boolean ok = true;
        if (s1.isEmpty() || s1 == null || s2.isEmpty() || s2 == null)
            return 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0) && i + s2.length() <= s1.length()) {
                for (int j = 0; j < s2.length(); j++) {
                    if (s1.charAt(i + j) != s2.charAt(j))
                        ok = false;
                }
                if (ok)
                    count++;
            }
        }
        return count;
    }
    //5
    public interface MyListInterface<T> {
        /**
         * Adds a String to the i"th link of the List.
         */
        public void addAt(T a, int i);

        /**
         * Removes the i"th element (link) of this List.
         */
        public void removeElementAt(int i);

        /**
         * Tests if ‘data’ is a member of this List.
         */
        public boolean contains(T data);

        /**
         * Returns the i"th element in this List.
         */
        public T get(int i);

        /**
         * Returns the number of Links in this List.
         */
        public int size();
        public static int Q5(MyListInterface  l){
            ArrayList<String> classes=new ArrayList<>();
            boolean ok=true;
            for (int i=0;i<l.size();i++){
                if (classes.contains(l.get(i).getClass().getName()))
                    classes.add(l.get(i).getClass().getName());
            }
        return classes.size();
    }
    }
    //6
    public static Boolean Q6(int n){
        if (n<30)
            return false;
        ArrayList<Integer> primeFactors = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            while (n % i == 0 ) {
                if (primeFactors.contains(i)) {
                    return false;
                }
                primeFactors.add(i);
                n /= i;
            }
        }
        return primeFactors.size() == 3;
    }
    //7
    public static double[] Q7(double[] arr) {
        int count = 1, startI = 0, maxR = 0, startMax = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                if (count == 1)
                    startI = i;
                count++;
            } else {
                if (count > maxR) {
                    maxR = count;
                    startMax = startI;
                }
                count = 1;
            }
        }
        if (count > maxR) {
            maxR = count;
            startMax = startI;
        }
        double[] mArr = new double[maxR];
        for (int i = startMax; i < startMax + mArr.length; i++) {
            mArr[i - startMax] = arr[i];
        }
        return mArr;
    }

    /** This is a simple interface for Binary Trees as published in: */
    public interface BinaryTree<T> {
        /** @return the left (sub) tree - might be null. */
        public BinaryTree<T> getLeft();
        /** @return the right (sub) tree - might be null. */
        public BinaryTree<T> getRight();
        public T getRoot(); // The root data (type T).
        public boolean isEmpty();
        /** @return the number of nodes in this tree. */
        public int size();
        /** Adds the data "a" to this tree, in a regular BT can be implemented using a random
         (left/right). In Binary Search Tree-is done using the InOrder (natural) Order. */
        public void add(T a);
        /** @return the i'th node using inorder “indexind”*/
        public T get(int i);
        /** search the binary tree for the first node that equals to t. If none returns null */
        public T find(T t);
        /** returns an in_order iterator */
        public Iterator<T> iterator();
        /** removes the first node that equals to t. If exists - returns it, else returns null */
        public T remove(T element);
    }
    /** Basic String Comparator – as defined in java.util*/
    class StringComparator implements Comparator<String> {
        public StringComparator(){;}
        public int compare(String obj1, String obj2) {
            if (obj1 == obj2) {return 0;}
            if (obj1 == null) {return -1;}
            if (obj2 == null) {return 1;}
            return obj1.compareTo(obj2);
        }
    }
    //8
    public static boolean isOfTheSameStructure(BinaryTree bt1, BinaryTree bt2) {
        if((bt1.isEmpty()|| bt1==null) && (bt2.isEmpty()|| bt2==null))
            return true;
        if((bt1.isEmpty()|| bt1==null) || (bt2.isEmpty()|| bt2==null))
            return false;
        return isOfTheSameStructure(bt1.getLeft(),bt2.getLeft()) && isOfTheSameStructure(bt1.getRight(),bt2.getRight());
    }
    //9
    public static <T> int q9(BinaryTree<T> bt1, int min, int max){
        if (bt1.isEmpty()|| bt1==null)
            return 0;
        return q9Helper(bt1,0,min,max);
    }
    public static <T> int q9Helper(BinaryTree<T> bt1,int level, int min, int max) {
        if (bt1.isEmpty()|| bt1==null)
            return 0;
        if (bt1.getLeft()==null && bt1.getRight()==null){
            if (level>=min && level<max)
                return 1;
            return 0;
        }
        if (level>=max)
            return 0;
        return q9Helper(bt1.getLeft(), level + 1, min, max) +
                q9Helper(bt1.getRight(), level + 1, min, max);
    }
    //10
    public static <T> ArrayList<T>  q10(BinaryTree<T> bt1){
        ArrayList<T> a=new ArrayList<>();
        if (bt1.isEmpty()|| bt1==null)
            return a;
        if (bt1.getLeft()==null && bt1.getRight()==null) {
            a.add(bt1.getRoot());
            return a;
        }
        if (bt1.getLeft() != null) {
            a.addAll(q10(bt1.getLeft()));
        }
        if (bt1.getRight() != null) {
            a.addAll(q10(bt1.getRight()));
        }
        return a;
    }
    //11
    public static double q11(BinaryTree bt) {
        if (bt == null || bt.isEmpty())
            return -1;
        if (bt.getLeft() == null && bt.getRight() == null)
            return 0;
        double x = 1 + Math.max(q11(bt.getLeft()),q11(bt.getRight()));
        double y = Math.log(bt.size()) / (int) (Math.log(2));
        return x / y;
    }
    //13
    public static <T> void mySort(T[] p, Comparator<T> comp) {
        quickSort(p, 0, p.length - 1, comp);
    }

    private static <T> void quickSort(T[] arr, int low, int high, Comparator<T> comp) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, comp);
            quickSort(arr, low, pivotIndex - 1, comp);
            quickSort(arr, pivotIndex + 1, high, comp);
        }
    }

    private static <T> int partition(T[] arr, int low, int high, Comparator<T> comp) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comp.compare(arr[j], pivot) <= 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    //14
    public class Point2D {
        public static final double EPS = 0.001;
        public final Point2D ORIGIN =new Point2D(0,0);
        private double _x, _y;
        public Point2D(double a,double b) {_x=a; _y=b;  }  // Standard Constructor.
        public Point2D(Point2D p) { this(p.x(), p.y()); }// Copy Constructor
        /** String Constructor: following this String structure:  "-1.2,5.3" --> (-1.2,5.3) ; */
        public Point2D(String s) {
            String[] a = s.split(",");
            _x = Double.parseDouble(a[0]);
            _y = Double.parseDouble(a[1]);  }
        public double x() {return _x;}
        public double y() {return _y;}
        public Point2D add(Point2D p) {
            return new Point2D(p.x()+x(),p.y()+this.y());  }
        /** Translates this point by a vector like representation of p. */
        public void move(Point2D p) {_x += p.x(); _y += p.y();}
        public String toString() {return _x+","+_y; }
        public double distance() {return this.distance(ORIGIN); }
        /** distance(this,p2) = Math.sqrt(dx^2 + dy^2) */
        public double distance(Point2D p2) {
            double dx = this.x() - p2.x(), dy = this.y() - p2.y();
            return Math.sqrt(dx*dx+dy*dy);   }
        /**return true iff: this point equals to p.  */
        public boolean equals(Object p)  {
            if(p==null || !(p instanceof Point2D)) {return false;}
            Point2D p2 = (Point2D)p;
            return (_x==p2._x) && (_y==p2.y());
        }
        public boolean equals(Point2D p) {
            if(p==null) {return false;}
            return ((_x==p._x) && (_y==p._y));  }
        public boolean close2equals(Point2D p2, double eps) {
            return (this.distance(p2) < eps);
        }
    }
    public class Elipse {
        private Point2D p;
        private Point2D q;
        private double n;

        public Elipse(double Xp, double Yp, double Xq, double Yq, double n) {
            this.p = new Point2D(Xp, Yp);
            this.q = new Point2D(Xq, Yq);
            this.n = n;
        }

        public Elipse(Elipse e) {
            this.p = new Point2D(e.p);
            this.q = new Point2D(e.q);
            this.n = e.n;
        }

        public int where(Point2D r) {
            double distance = this.p.distance(r) + this.q.distance(r);
            if (distance < this.n)
                return -1;
            if (distance == this.n)
                return 0;
            return 1;
        }

        public boolean equals(Elipse e) {
            return this.p.equals(e.p) && this.q.equals(e.q) && this.n == e.n;
        }
    }
    //15,16
    interface Parabula {
        double f(double x); // computes the value of this parabula at x.

        Parabula add(Parabula p); // computes a new Parabula = p + “this”.

        double[] get(); // retunrs an array of doubles {a,b,c}: ax^2+bx+c=0;

        double extream(Parabula p); // returns the x value of the extrema point
        //(min or max), if none throws an Exception
    }

    public class F2 implements Parabula {
        private double a;
        private double b;
        private double c;

        public F2(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double f(double x) {
            return this.a * Math.pow(x, 2) + this.b * x + this.c;
        }

        @Override
        public Parabula add(Parabula p) {
            return new F2(this.a += p.get()[0], this.a += p.get()[0], this.a += p.get()[0]);
        }

        @Override
        public double[] get() {
            return new double[]{this.a, this.b, this.c};
        }

        @Override
        public double extream(Parabula p) {
            try {
                return -p.get()[1] / (2 * p.get()[0]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private static int numberOfRealRoots(Parabula p) {
            if (p.f(p.extream(p)) > 0 && p.get()[0] > 0)
                return 0;
            if (p.f(p.extream(p)) < 0 && p.get()[0] < 0)
                return 0;
            if (p.f(p.extream(p)) == 0)
                return 1;
            return 2;
        }

        //            private static int numberOfRealRoots(Parabula p) {
//            if(Math.pow(p.get()[1],2)-4*p.get()[0]*p.get()[2]>0)
//                return 2;
//             if(Math.pow(p.get()[1],2)-4*p.get()[0]*p.get()[2]==0)
//                 return 1;
//             return 0;
//         }
        private static void sort(ArrayList<Parabula> a) {
            ArrayList<Parabula> result = new ArrayList<>();
            int maxIndex = 0;
            double maxY = a.get(0).f(a.get(0).extream(a.get(0)));


            while (!a.isEmpty()) {
                for (int i = 1; i < a.size(); i++) {
                    double yi = a.get(i).f(a.get(i).extream(a.get(i)));
                    if (yi > maxY) {
                        maxY = yi;
                        maxIndex = i;
                    }
                }
                result.add(a.get(maxIndex));
                a.remove(maxIndex);
            }
            a=result;
        }
    }
    //18
    public static String[] allCodes(){
        String[]arr=new String[120];
        return arr;
    }
}