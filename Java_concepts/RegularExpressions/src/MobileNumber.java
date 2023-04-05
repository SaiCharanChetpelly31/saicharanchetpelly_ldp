import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileNumber {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(0|91)?[6-9][0-9]{9}");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Matcher m = p.matcher(s);
        if(m.find() && m.group().equals(s))
            System.out.println("valid mobile number");
        else
            System.out.println("invalid mobile number");
    }
}
