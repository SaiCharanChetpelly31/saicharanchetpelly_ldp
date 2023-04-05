package list.vector;

import java.util.Stack;

public class StackDemo {
    public static void main(String args[]){
        Stack<String> stack = new Stack<String>();
        stack.push("sai");
        stack.push("charan");
        stack.push("raju");
        stack.push("ram");
        stack.push("raghu");
        stack.pop();
        System.out.println(stack);
    }
}
