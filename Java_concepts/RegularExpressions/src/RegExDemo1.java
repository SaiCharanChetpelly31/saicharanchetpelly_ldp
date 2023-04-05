import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo1 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("ab");
        Matcher m = p.matcher("abbabcab");
        int count=0;
        while(m.find()){
            count++;
            //m.end() returns endIndex+1
            System.out.println(m.start()+" "+m.end()+" "+m.group());
        }
        System.out.println("ab occured "+count+" number of times");
    }
}
