package cursors;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("balakrishna");
        list.add("nag");
        list.add("chiru");
        list.add("venky");
        System.out.println(list);
        ListIterator itr = list.listIterator();
        while (itr.hasNext()){
            String str = (String) itr.next();
            if(str.equals("balakrishna")){
                itr.remove();
            }
            else if(str.equals("chiru")){
                itr.add("charan");
            }
            else if(str.equals("nag")){
                itr.set("chaitu");
            }
        }
        System.out.println(list);
    }
}
