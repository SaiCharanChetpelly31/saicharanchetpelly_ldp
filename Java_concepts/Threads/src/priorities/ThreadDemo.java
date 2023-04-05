package priorities;

class ThreadDemo extends Thread {

    public void run()
    {
        System.out.println("Inside run method");
    }

    public static void main(String[] args)
    {
        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();
        ThreadDemo t3 = new ThreadDemo();

        // Thread 1
        // Display the priority of above thread
        // using getPriority() method
        System.out.println("t1 thread priority : "
                + t1.getPriority());

        // Thread 2
        // Display the priority of above thread
        System.out.println("t2 thread priority : "
                + t2.getPriority());

        // Thread 3
        System.out.println("t3 thread priority : "
                + t3.getPriority());

        // Setting priorities of above threads by
        // passing integer arguments
        t1.setPriority(2);
        t2.setPriority(5);
        t3.setPriority(8);

        // t3.setPriority(21); will throw
        // IllegalArgumentException

        // 2
        System.out.println("t1 thread priority : "
                + t1.getPriority());

        // 5
        System.out.println("t2 thread priority : "
                + t2.getPriority());

        // 8
        System.out.println("t3 thread priority : "
                + t3.getPriority());

        System.out.println(
                "Currently Executing Thread : "
                        + Thread.currentThread().getName());

        System.out.println(
                "Main thread priority : "
                        + Thread.currentThread().getPriority());


        Thread.currentThread().setPriority(10);

        System.out.println(
                "Main thread priority : "
                        + Thread.currentThread().getPriority());
    }
}
//TC-O(1)
//SC-O(1)
