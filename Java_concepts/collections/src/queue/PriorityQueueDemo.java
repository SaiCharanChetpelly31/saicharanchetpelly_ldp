package queue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String args[]){
        PriorityQueue<String> queue=new PriorityQueue<String>();
        queue.add("sai charan");
        queue.add("Raj");
        queue.add("Ram");
        queue.add("Raghu");
        System.out.println("head:"+queue.element());
        System.out.println("head:"+queue.peek());
        System.out.println(queue);
        queue.remove();
        queue.poll();
        System.out.println("after removing two elements:");
        System.out.println(queue);

    }
}
