package queue.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {

        public static void main(String[] args) {
//Creating Deque and adding elements
            Deque<String> deque = new ArrayDeque<>();
            deque.add("Gautam");
            deque.add("Karan");
            deque.add("Ajay");
//Traversing elements
            for (String str : deque) {
                System.out.println(str);
            }
        }

}
