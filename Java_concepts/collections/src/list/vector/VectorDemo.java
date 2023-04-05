package list.vector;

import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {
    public static void main(String args[]){
        Vector<String> v=new Vector<String>();
        v.add("sai");
        v.add("charan");
        v.add("raju");
        v.add("rishi");
        Iterator<String> itr=v.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
