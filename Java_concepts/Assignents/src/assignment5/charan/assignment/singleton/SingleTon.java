package assignment5.charan.assignment.singleton;

public class SingleTon {
    String userName;
    public static SingleTon printValues(String userName){
        //In Java, a non-static member variable cannot be accessed from a static context.
        // Therefore, it is not possible to initialize a non-static member variable inside a static method.
        // To achieve this functionality,
        // we can create a singleton class with a private constructor and a static method to get an instance of that class. '
//        this.userName = userName;
        return new SingleTon();
    }

    public void printValues1(){
        System.out.println(this.userName);
    }
}
