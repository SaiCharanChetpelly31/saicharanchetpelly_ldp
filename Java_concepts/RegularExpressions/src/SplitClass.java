
import java.util.regex.Pattern;

public class SplitClass {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\s");
        String s[] = p.split("sai charan chetpelly");
        for (String s1:s) {
            System.out.println(s1);
        }

        Pattern p2 = Pattern.compile("[.]");
        String s2[] = p2.split("www.google.com");
        for (String s3:s2) {
            System.out.println(s3);
        }
    }
}
