import java.util.ArrayList;
import java.util.*;
import java.io.*;

// alternate solution:
//    each node in the stock stores additional data, namely the maximum in the substack below it


class Problem9_2 {
    public static void main(String[] args) {
        System.out.println(evaluateRPN("3,4,x,2,3,+,+"));
    }

    public static Integer evaluateRPN(String exp) {
        Deque<Integer> stack = new LinkedList<Integer>();

        String[] symbols = exp.split(",");

        for (String token : symbols) {
            if ("+-x/".contains(token)) { // operator found
                Integer s2 = stack.removeFirst();
                Integer s1 = stack.removeFirst();

                if (token.equals("+")) {
                    stack.addFirst(s1 + s2);
                } else if (token.equals("-")) {
                    stack.addFirst(s1 - s2);
                } else if (token.equals("x")) {
                    stack.addFirst(s1 * s2);
                } else if (token.equals("/")) {
                    stack.addFirst(s1 / s2);
                }
            }
            else { 
                stack.addFirst(Integer.parseInt(token));
            }
        }

        return stack.removeFirst();
    }
}