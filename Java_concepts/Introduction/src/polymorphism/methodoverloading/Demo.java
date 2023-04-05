package polymorphism.methodoverloading;

public class Demo {
    public int sum(int a,int b){
        return a+b;
    }
    public double sum(double a,double b){
        return  a+b;
    }
    public int sum(int a,int b,int c){
        return a+b+c;
    }

    public static void main(String[] args) {
        Demo m = new Demo();
        System.out.println(m.sum(10,20));
        System.out.println(m.sum(10.2,20.4));
        System.out.println(m.sum(10,20,30));
        System.out.println(m.sum(10.2f,20.3));
    }
}
