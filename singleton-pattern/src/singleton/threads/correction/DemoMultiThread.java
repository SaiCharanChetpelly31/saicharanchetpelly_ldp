package singleton.threads.correction;

public class DemoMultiThread {
    public static void main(String[] args) {
        ThreadDemo1 thread1 = new ThreadDemo1();
        ThreadDemo2 thread2 = new ThreadDemo2();
        thread1.start();
        thread2.start();
    }
    static class ThreadDemo1 extends Thread {
        @Override
        public void run() {
            Samosa singleton = Samosa.getSamosa();
            System.out.println(singleton.hashCode());
        }
    }

    static class ThreadDemo2 extends Thread {
        @Override
        public void run() {
            Samosa singleton = Samosa.getSamosa();
            System.out.println(singleton.hashCode());
        }
    }
}
