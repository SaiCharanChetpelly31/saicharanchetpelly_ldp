package creation;

public class Method2 {
    public static void main(String[] args) {
        ThreadDemo s=new ThreadDemo(); //object for runnable interface
        Thread t=new Thread(s);
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread "+i);
        }
    }
}

class ThreadDemo implements Runnable{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Child Thread "+i);
        }
    }
}
