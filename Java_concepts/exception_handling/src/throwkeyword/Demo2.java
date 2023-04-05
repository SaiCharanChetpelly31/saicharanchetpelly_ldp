package throwkeyword;

public class Demo2  extends  RuntimeException{
    public static void main(String[] args) {
        try{
            throw new Demo2();
        }
        finally {
            System.out.println("finally");
        }
    }
}
