import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem8_7 {
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

        ListNode<Integer> out = removeKthLast(l1, 5);
        while (out != null) {
            System.out.println(out.data);
            out = out.next;
        }
    }
    
    public static ListNode<Integer> removeKthLast(ListNode<Integer> head, int k) {
        // pointer to head for returning the results
        ListNode<Integer> res = head;

        // sentinel pointer to find end of list
        ListNode<Integer> sent = head;

        // send pointer k forward
        while (k-- > 0) {
            sent = sent.next;
        }

        // edge case: kth last is first element
        if (sent == null) {
            return res.next;
        }

        // iterate both head and sentinel in tandem until sentinel reaches end; then head will be at kth last
        while (sent.next != null) {
            sent = sent.next;
            head = head.next;
        }

        // head is at (k-1)th last node, delete kth node
        head.next = head.next.next;

        return res;
    }
}
