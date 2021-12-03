import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

class Problem9_4 {
    public static void main(String[] args) {
        System.out.println(normalisePathname("../../..//./usr"));
    }

    public static String normalisePathname(String path) {
        Deque<String> stack = new LinkedList<String>();

        String[] sArr = path.split("/");
        if (sArr[0] == "") {
            // starts with /
            stack.addFirst("/");
        }
        for (String s : sArr) {
            if (s.equals("..")) {
                if (stack.peekFirst() == "/") {
                    throw new IllegalStateException("Cannot go up from root directory");
                }
                if (stack.isEmpty() || stack.peekFirst().equals("..")) {
                    stack.addFirst(s);
                }
                else {
                    stack.removeFirst();
                }
            }
            else if (!s.equals(".") && !s.equals("")){
                stack.addFirst(s);
            }
        }
        
        StringBuilder ret = new StringBuilder();

        if (!stack.isEmpty()) {
            Iterator<String> it = stack.descendingIterator();
            String prev = it.next();
            ret.append(prev);
            while (it.hasNext()) {
                if (!prev.equals("/")) {
                    ret.append("/");
                }
                prev = it.next();
                ret.append(prev);
            }
        }
        
        return ret.toString();
    }
        
}
