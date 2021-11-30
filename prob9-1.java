import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem9_1 {
    public static void main(String[] args) {
        Stack s1 = new Stack();
        s1.push(5);
        s1.push(2);
        s1.push(1);
        s1.push(9);
        s1.push(3);

        System.out.println(s1.max());
        
        s1.pop();
        s1.pop();

        System.out.println(s1.max());
    }
}

class Stack {
    private Deque<Integer> stack;
    private Deque<Integer> maxStack;

    public Stack() {
        stack = new LinkedList<Integer>();
        maxStack = new LinkedList<Integer>();
    }

    public void push(Integer i) {
        if (stack.isEmpty() || i > maxStack.peek()) {
            maxStack.push(i);
        }
        stack.push(i);
    }

    public Integer pop() {
        if (stack.peek() == maxStack.peek()) {
            maxStack.pop();
        }
        return stack.pop();
    }
    
    public Integer max() {
        return maxStack.peek();
    }
}