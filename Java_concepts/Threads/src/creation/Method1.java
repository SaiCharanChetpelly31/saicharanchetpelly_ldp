package creation;

public class Method1 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread "+i);
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("child thread "+i);
        }
    }
}
