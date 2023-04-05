import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo3 {
    public static void main(String[] args) {
        ArrayList<Integer>  list= new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(25);
        list.add(1);
        System.out.println(list);
        Comparator<Integer> c = (i1,i2) -> i1<i2?-1:i1>i2?1:0;
        Collections.sort(list,c);
        System.out.println(list);
    }
}
//Comparator
//
//int compare(Object obj1,O0bject obj2)
//returns E0) iff obj1 has to come before obj2
//returns +ve iff objl has to come after obj2
//returns @ iff obj1 and obj2 are equal
