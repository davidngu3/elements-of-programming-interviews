import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem9_1 {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(5);
        stack.push(6);
        stack.push(2);
        stack.push(4);

        System.out.println(max(stack));

    }

    public static Integer max(LinkedList<Integer> s) {
        LinkedList<Integer> tempStack = new LinkedList<>();

        int max = Integer.MIN_VALUE;
        while (!s.isEmpty()) {
            int curr = s.pop();
            tempStack.push(curr);
            if (curr > max) {
                max = curr;
            }
        }

        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }
        
        return max;
    }

}
