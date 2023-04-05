import java.util.ArrayList;
import java.util.Collections;

public class Demo4 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("sai charan",301));
        list.add(new Employee("raju",200));
        list.add(new Employee("sai",145));
        list.add(new Employee("charan",154));
        list.add(new Employee("ramu",101));
        Collections.sort(list,(e1,e2)->e1.eId<e2.eId?-1:e1.eId>e2.eId?1:0);
        System.out.println(list);
        Collections.sort(list,(e1,e2)->e1.name.compareTo(e2.name));
        System.out.println(list);
    }
}
class Employee {
    String name;
    int eId;

    public Employee(String name,int eId){
        this.name = name;
        this.eId = eId;
    }

    @Override
    public String toString() {
        return eId+":"+name;
    }
}
