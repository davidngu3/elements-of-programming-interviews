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

        System.out.println(isPalindromic(l1));
    }
    
    public static ListNode<Integer> isPalindromic(ListNode<Integer> head) {
      
        return new ListNode<Integer>(0, null);
    }
}
