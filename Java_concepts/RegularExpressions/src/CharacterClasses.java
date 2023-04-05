import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterClasses {
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("[abc]");
        Pattern p2 = Pattern.compile("[^abc]");
        Pattern p3 = Pattern.compile("[a-z]");
        Pattern p4 = Pattern.compile("[A-Z]");
        Pattern p5 = Pattern.compile("[0-9]");
        Pattern p6 = Pattern.compile("[a-zA-Z0-9]");
        Pattern p7 = Pattern.compile("[^a-zA-Z0-9]");
        Matcher m = p1.matcher("a7b@z#9");
        System.out.println("printing output for [abc]");
        print(m);

        m=p2.matcher("a7b@z#9");
        System.out.println("printing output for [^abc]");
        print(m);

        m=p3.matcher("a7b@z#9");
        System.out.println("printing output for [a-z]");
        print(m);

        m=p4.matcher("a7b@z#9");
        System.out.println("printing output for [A-Z]");
        print(m);

        m=p5.matcher("a7b@z#9");
        System.out.println("printing output for [0-9]");
        print(m);

        m=p6.matcher("a7b@z#9");
        System.out.println("printing output for [a-zA-Z0-9]");
        print(m);

        m=p7.matcher("a7b@z#9");
        System.out.println("printing output for [^a-zA-Z0-9]");
        print(m);

    }
    public static void print(Matcher m){
        while(m.find()){
            System.out.println(m.start()+"..."+m.group());
        }
    }
}
