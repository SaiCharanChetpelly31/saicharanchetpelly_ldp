package throwskeyword;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("making thread inactive");
        Thread.sleep(2000);
        System.out.println("thread is active now");
    }
}
