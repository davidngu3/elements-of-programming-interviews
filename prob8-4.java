import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem8_4 {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        l1.add(1);
        l1.add(3);
        l1.add(7);
        l1.add(9);
        l1.add(16);

        LinkedList<Integer> l2 = new LinkedList<Integer>();
        l2.add(2);
        l2.add(4);
        l2.add(9);
        l2.add(15);
        l2.add(15);
        l2.add(20);

        mergeTwoSortedLL(l1, l2);

    }
    
    public static LinkedList<Integer> mergeTwoSortedLL(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        Integer l1_idx = 0;
        Integer l2_idx = 0;
        
        while (l1_idx < l1.size() || l2_idx < l2.size()) {
            if (l1_idx > l1.size() - 1) { // l1 index out of bound
                l1.add(l2.get(l2_idx));
                l2_idx++;
            }

            else if (l2_idx > l2.size() - 1) { // l2 index out of bound
                l1_idx++;
            }

            else if (l1.get(l1_idx) < l2.get(l2_idx)) { // l1 < l2
                l1_idx++;
            }
            else if (l1.get(l1_idx) >= l2.get(l2_idx)) { // l1 > l2
                l1.add(l1_idx, l2.get(l2_idx));
                l2_idx++;
            }
        }

        return l1;
    }
}
