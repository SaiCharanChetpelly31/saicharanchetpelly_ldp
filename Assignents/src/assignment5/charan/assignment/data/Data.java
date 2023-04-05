package assignment5.charan.assignment.data;

public class Data {
    int var;
    char ch;

    public void printInfo1(){
        System.out.println(var);
        System.out.println(ch);
    }

   public void printInfo2(){
        int num=0;
        char ch1='a';
        //local variables must be initialized before they can be used. If you declare a
        // local variable without initializing it, the Java compiler will give a compile-time error.
       System.out.println(num);
       System.out.println(ch1);
   }
}
