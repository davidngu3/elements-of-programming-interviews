import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem8_4 {
    public static void main(String[] args) {
        ListNode<Integer> l1 = new ListNode<Integer>(11, null);
        ListNode<Integer> l3 = new ListNode<Integer>(3, null);
        ListNode<Integer> l4 = new ListNode<Integer>(5, null);
        ListNode<Integer> l5 = new ListNode<Integer>(7, null);
        ListNode<Integer> l6 = new ListNode<Integer>(2, null);
        
        l1.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode<Integer> l2 = new ListNode<Integer>(11, null);
        ListNode<Integer> l7 = new ListNode<Integer>(3, null);
        
        l2.next = l7;
        l7.next = l4;

        System.out.println(hasCommonNode(l1, l2));
    }
    
    public static boolean hasCommonNode(ListNode<Integer> l1, ListNode<Integer> l2) {
        // traverse L1 to end
        while (l1.next != null) {
            l1 = l1.next;
        }

        // traverse L2 to end
        while (l2.next != null) {
            l2 = l2.next;
        }

        return l1 == l2;
    }
}
