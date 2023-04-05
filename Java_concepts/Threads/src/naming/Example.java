package naming;

public class Example {
    public static void main(String[] args) {
        MyThread t = new MyThread("charan");
        System.out.println(t.getName());

        t.setName("sai");
        System.out.println(t.getName());
    }
}
class MyThread extends Thread{
    public MyThread(String name){
        super.setName(name);
    }
}
//TC-O(1)
//SC-O(1)


