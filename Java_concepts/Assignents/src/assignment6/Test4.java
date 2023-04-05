package assignment6;

public class Test4 {
    public Test4(String name){
        System.out.println("Constructor called with message "+name);
    }

    public static void main(String[] args) {
        Test4[] arr = new Test4[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Test4("Object " + i);
        }
    }
}

