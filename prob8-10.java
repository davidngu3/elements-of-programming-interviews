import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem8_10 {
    public static void main(String[] args) {
        ListNode<Integer> l1 = new ListNode<Integer>(1, null);
        ListNode<Integer> l3 = new ListNode<Integer>(2, null);
        ListNode<Integer> l4 = new ListNode<Integer>(3, null);
        ListNode<Integer> l5 = new ListNode<Integer>(4, null);
        ListNode<Integer> l6 = new ListNode<Integer>(5, null);
        ListNode<Integer> l7 = new ListNode<Integer>(6, null);
            
        l1.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode<Integer> out = evenOddMerge(l1);
        while (out != null) {
            System.out.println(out.data);
            out = out.next;
        }
    }
    
    public static ListNode<Integer> evenOddMerge(ListNode<Integer> head) {
        // pointers
        ListNode<Integer> odd = new ListNode<Integer>(0, null);
        ListNode<Integer> tempOdd = odd;
        ListNode<Integer> tempHead = head;

        // compute even nodes
        while (head.next != null && head.next.next != null) {
            // add next node to odd list
            odd.next = head.next;
            odd = odd.next;

            head.next = head.next.next;
            head = head.next;
        }

        // possible dangling odd node
        if (head.next != null) {
            odd.next = head.next;
            odd = odd.next;
        }

        // detach odd to even;
        odd.next = null;

        head.next = tempOdd.next;

        return tempHead;
    }
}
