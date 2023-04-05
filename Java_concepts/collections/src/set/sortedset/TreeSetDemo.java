package set.sortedset;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add("A");
        ts.add("a");
        ts.add("o");
        ts.add("F");
//        System.out.println(ts.add(new Integer(10))); //class cast exception
        ts.add(null); //NPE
        System.out.println(ts);
    }
}
