package singleton.lazy;


public class Example {
    public static void main(String[] args) {
        Samosa s1 = Samosa.getInstance();
        System.out.println(s1.hashCode());
        Samosa s2 = Samosa.getInstance();
        System.out.println(s2.hashCode());
    }
}
