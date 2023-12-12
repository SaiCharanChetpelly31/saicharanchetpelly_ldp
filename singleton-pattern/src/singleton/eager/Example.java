package singleton.eager;

public class Example {
    public static void main(String[] args) {
        Samosa s1 = Samosa.getSamosa();
        System.out.println(s1.hashCode());
        Samosa s2 = Samosa.getSamosa();
        System.out.println(s2.hashCode());
    }
}
