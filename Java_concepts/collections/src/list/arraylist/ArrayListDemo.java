package list.arraylist;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add("A");
        list.add(10);
        list.add("A");

        list.add(null);
        System.out.println(list);// [A, 10, A, null]

        list.remove(2);
        System.out.println(list);// [A, 10, null]
        list.add(2,"m");
        list.add("n");
        System.out.println(list);

    }
}
