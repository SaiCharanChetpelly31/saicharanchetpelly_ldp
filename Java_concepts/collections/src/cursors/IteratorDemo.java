package cursors;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Integer val = (Integer) iterator.next();
            if(val%2==0)
                System.out.println(val);
            else
                iterator.remove();
        }
        System.out.println(list);
    }
}
