package basics;
//type casting
public class Conversion {
    public static void main(String[] args) {
        double myDouble = 3.14;
        float myFloat = 3.14f;  //narrowing/lossy conversion
        double yourDouble = myFloat;  //widening/lossless conversion
        System.out.println(myFloat);
        System.out.println(myDouble);
    }
}
