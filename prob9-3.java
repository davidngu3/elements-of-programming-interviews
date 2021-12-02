import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem9_3 {
    public static void main(String[] args) {
        System.out.println(isWellFormed("({}()({}))"));
    }

    public static boolean isWellFormed(String exp) {
        char[] chars = exp.toCharArray();
        Deque<Character> stack = new LinkedList<Character>();

        for (Character c : chars) {
            if (c.equals('}')) {
                if (!stack.peekFirst().equals('{')) {
                    return false;
                }
                stack.removeFirst();
            }
            else if (c.equals(')')) {
                if (!stack.peekFirst().equals('(')) {
                    return false;
                }
                stack.removeFirst();
            }
            else if (c.equals(']')) {
                if (!stack.peekFirst().equals('[')) {
                    return false;
                }
                stack.removeFirst();
            }
            else if ("{([".indexOf(c) >= 0) {
                stack.addFirst(c);
            }
        }

        return stack.isEmpty();
    }
}