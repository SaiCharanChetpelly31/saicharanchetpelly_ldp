import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-z0-9]+([.][a-zA-Z0-9]+)+");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Matcher m = p.matcher(s);
        if(m.find() && m.group().equals(s))
            System.out.println("valid email");
        else
            System.out.println("invalid email");
    }
}
