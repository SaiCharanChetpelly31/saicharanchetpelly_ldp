package list.linkedlist;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add("sai");
        ll.add(30);
        ll.add(null);
        ll.add("sai");
        ll.set(0, "charan");
        ll.add("ccc");
        System.out.println(ll);
    }
}
