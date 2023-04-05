import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quantifiers {
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("a");
        Pattern p2 = Pattern.compile("a+");
        Pattern p3 = Pattern.compile("a*");
        Pattern p4 = Pattern.compile("a?");

        Matcher m = p1.matcher("abaabaaab");
        System.out.println("printing output for a");
        print(m);

        m=p2.matcher("abaabaaab");
        System.out.println("printing output for a+");
        print(m);

        m=p3.matcher("abaabaaab");
        System.out.println("printing output for a*");
        print(m);

        m=p4.matcher("abaabaaab");
        System.out.println("printing output for a?");
        print(m);

    }
    public static void print(Matcher m){
        while(m.find()){
            System.out.println(m.start()+"..."+m.group());
        }
    }

}

