import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PreDefinedCharacterClasses {
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("\\s");
        Pattern p2 = Pattern.compile("\\S");
        Pattern p3 = Pattern.compile("\\d");
        Pattern p4 = Pattern.compile("\\D");
        Pattern p5 = Pattern.compile("\\w");
        Pattern p6 = Pattern.compile("\\W");
        Pattern p7 = Pattern.compile(".");
        Matcher m = p1.matcher("a7b k@9");
        System.out.println("printing output for s");
        print(m);

        m=p2.matcher("a7b k@9");
        System.out.println("printing output for S");
        print(m);

        m=p3.matcher("a7b k@9");
        System.out.println("printing output for d");
        print(m);

        m=p4.matcher("a7b k@9");
        System.out.println("printing output for D");
        print(m);

        m=p5.matcher("a7b k@9");
        System.out.println("printing output for w");
        print(m);

        m=p6.matcher("a7b k@9");
        System.out.println("printing output for W");
        print(m);

        m=p7.matcher("a7b k@9");
        System.out.println("printing output for .");
        print(m);

    }
    public static void print(Matcher m){
        while(m.find()){
            System.out.println(m.start()+"..."+m.group());
        }
    }

}

