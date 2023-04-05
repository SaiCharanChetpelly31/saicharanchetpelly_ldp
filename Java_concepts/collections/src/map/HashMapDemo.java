package map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String args[]){
        Map<Integer,String> map=new HashMap<>();
        map.put(100,"sai");
        map.put(101,"charan");
        map.put(102,"Rahul");
        map.remove(100);
        map.remove(102, "Rahul");
        map.replace(102, "ram");
        //Elements can traverse in any order
        for(Map.Entry m:map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}
