import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem8_3 {
    public static void main(String[] args) {
        ListNode<Integer> l0 =  new ListNode<Integer>(12, null);
        ListNode<Integer> l1 = new ListNode<Integer>(11, null);
        ListNode<Integer> l2 = new ListNode<Integer>(3, null);
        ListNode<Integer> l3 = new ListNode<Integer>(5, null);
        ListNode<Integer> l4 = new ListNode<Integer>(7, null);
        ListNode<Integer> l5 = new ListNode<Integer>(2, null);
        
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l2;

        System.out.println(hasCycle(l0));
    }
    
    // uses floyds cycle detection algorithm
    public static ListNode<Integer> hasCycle(ListNode<Integer> head) {
        
        // two pointers, slow and fast
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;

        boolean cycleDetected = false;
        int cycleLength = 0;

        while (fast.next != null && fast.next.next != null) {
            if (cycleDetected) {
                cycleLength++;
            }

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // cycle detected, find cycle head

                if (cycleDetected == true) { // 2nd time collision: find head of cycle;
                    ListNode<Integer> temp = head;
                    int i = 0;
                    while (i++ < cycleLength) {
                        temp = temp.next;
                    }

                    // move head and temp equivalently to find head of cycle
                    while (head != temp) {
                        head = head.next;
                        temp = temp.next;
                    }

                    return head;
                }
                // find length of cycle
                cycleDetected = true;

            }

        }

        return new ListNode<Integer>(-1, null); // if fast reaches null, then no cycle exists (fast >> slow)
    }
}
