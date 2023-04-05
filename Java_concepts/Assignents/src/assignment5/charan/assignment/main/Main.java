package assignment5.charan.assignment.main;

import assignment5.charan.assignment.data.Data;
import assignment5.charan.assignment.singleton.SingleTon;

public class Main {
    public static void main(String[] args) {
        Data d1 = new Data();
        d1.printInfo1();
        d1.printInfo2();

        SingleTon s1 = SingleTon.printValues("charan");
       s1.printValues1();
    }
}
