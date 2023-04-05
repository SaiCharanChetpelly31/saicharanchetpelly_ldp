package assignment6.vampirenumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Optimized1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int i=1;
        while(count<100){
            if(getNoDigits(i)%2==0){
                if(checkVampire(i,count)){
                    count++;
                }

            }
            i++;
        }

    }
    public static int getNoDigits(int num) {
        return (int) Math.log10(num) + 1;
    }
    static String splitIntoDigits(int num1, int num2,int num) {

        StringBuilder res = new StringBuilder();
        int len = getNoDigits(num);
        int digits[] = new int[len];
        int j=0;
        while (num1 > 0) {
            digits[j]=num1%10;
            j++;
            num1 /= 10;
        }
        while (num2 > 0) {
            digits[j]=num2%10;
            j++;
            num2/= 10;
        }
        Arrays.sort(digits); //0(nlogn)

        //0(n)
        for (int i : digits) {
            res.append(i);
        }


        return res.toString();
    }
    public static boolean checkVampire(int num,int count){
        String numStr = splitIntoDigits(num,0,num);

        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                int factor1Dig = getNoDigits(i);
                int factor2Dig = getNoDigits(num/i);
                int numDigits = getNoDigits(num);
                if(factor1Dig+factor2Dig==numDigits && factor1Dig==numDigits/2 && factor2Dig==numDigits/2 && numStr.equals(splitIntoDigits(i,num/i,num)) && !checkTrailingZeros(i,num/i)){
                    System.out.println(num);
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkTrailingZeros(int num1,int num2){
        if(num1%10 == 0 && num2%10 == 0)
            return true;
        return false;
    }
}
