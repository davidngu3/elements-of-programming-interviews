import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem8_2 {
    public static void main(String[] args) {
        ListNode<Integer> l1 = new ListNode<Integer>(11, null);
        ListNode<Integer> l2 = new ListNode<Integer>(3, null);
        ListNode<Integer> l3 = new ListNode<Integer>(5, null);
        ListNode<Integer> l4 = new ListNode<Integer>(7, null);
        ListNode<Integer> l5 = new ListNode<Integer>(2, null);
        
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
    
        ListNode<Integer> res = reverseSublist(l1, 2, 4); // should reverse to 11, 7, 5, 3, 2.

        while (res != null) {
            System.out.println(res.data);
            res = res.next;
        }
    }
    
    public static ListNode<Integer> reverseSublist(ListNode<Integer> l, int s, int f) {
        ListNode<Integer> start = l;

        // bring l to just before the start of reversed sublist, keep reference
        for (int i = 1; i < s-1; i++) {
            l = l.next;
        }
        ListNode<Integer> left = l;
    
        l = l.next; 

        // create reversed sublist
        ListNode<Integer> r = new ListNode<Integer>(l.data, null);
        for (int j = s; j < f; j++) {
            l = l.next;
            ListNode<Integer> newHead = new ListNode<Integer>(l.data, r);
            r = newHead;
        }

        // attach the start
        left.next = r;

        // attach the end
        while (r.next != null) {
            r = r.next;
        }
        r.next = l.next;

        return start;
    }
}
