package assignment6.vampirenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BruteForce {
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
    //O(n*sqrt(n)*log(n)).
    public static int getNoDigits(int num) {
        return (int) Math.log10(num) + 1;
    }
//    TC - O(log n)
    public static boolean checkVampire(int num,int count){
        String numStr = splitIntoDigits(num,0);

        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                int factor1Dig = getNoDigits(i);
                int factor2Dig = getNoDigits(num/i);
                int numDigits = getNoDigits(num);
                if(factor1Dig+factor2Dig==numDigits && factor1Dig==numDigits/2 && factor2Dig==numDigits/2 && numStr.equals(splitIntoDigits(i,num/i)) && !checkTrailingZeros(i,num/i)){
                    System.out.println(num);
                    return true;
                }
            }
        }
        return false;
    }
    //O(n*sqrt(n)*log(n))
    static String splitIntoDigits(int num, int num2) {

        StringBuilder res = new StringBuilder();
        ArrayList<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num%10);
            num /= 10;
        }
        while (num2 > 0) {
            digits.add(num2%10);
            num2/= 10;
        }
        Collections.sort(digits); //0(nlogn)

        //0(n)
        for (int i : digits) {
            res.append(i);
        }


        return res.toString();
    }
    //O(nlogn) - tc
    //o(n)-sc
    public static boolean checkTrailingZeros(int num1,int num2){
        if(num1%10 == 0 && num2%10 == 0)
            return true;
        return false;
    }
    //o(1)
}
