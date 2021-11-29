import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem8_11 {
    public static void main(String[] args) {
        ListNode<Integer> l1 = new ListNode<Integer>(1, null);
        ListNode<Integer> l3 = new ListNode<Integer>(2, null);
        ListNode<Integer> l4 = new ListNode<Integer>(3, null);
        ListNode<Integer> l5 = new ListNode<Integer>(3, null);
        ListNode<Integer> l6 = new ListNode<Integer>(2, null);
        ListNode<Integer> l7 = new ListNode<Integer>(1, null);
            
        l1.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        System.out.println(isPalindromic(l1));
        
    }
    
    public static boolean isPalindromic(ListNode<Integer> head) {
        
        // reverse list
        ListNode<Integer> reverse = reverseList(head);
        
        while (reverse != null && head != null) {
            if (reverse == null || head == null) { // one list shorter than the other
                return false;
            } 
            if (reverse.data != head.data) { // unequal
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }  
        return true;

    }

    public static ListNode<Integer> reverseList(ListNode<Integer> head) {
        
        // reverse list
        ListNode<Integer> dummy = new ListNode<Integer>(0, head);

        ListNode<Integer> prev = dummy;
        ListNode<Integer> curr = head;
        ListNode<Integer> temp;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        head.next = null;

        // check palindromicity

        return prev;
    }

    
}
