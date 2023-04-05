package assignment1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class assignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input string");
        String input = sc.nextLine();
        System.out.println(isValid(input.toLowerCase()));
    }
    public static boolean isValid(String str){
        boolean temp[] = new boolean[26];
        Arrays.fill(temp,false);
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int ascii = ch;
            if(ascii>=97 && ascii<=122){
                temp[ascii%97]=true;
            }
        }
        for(int i=0;i<str.length();i++){
            if(!temp[i])
                return false;
        }
        return true;
    }
}
//TC-O(N)
//SC-O(1)
