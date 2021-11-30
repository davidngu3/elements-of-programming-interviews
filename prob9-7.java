import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem9_7 {
    public static void main(String[] args) {
       BinaryTreeNode<Integer> head = new BinaryTreeNode<Integer>(1, null, null);
       head.left = new BinaryTreeNode<Integer>(2, null, null);
       head.right = new BinaryTreeNode<Integer>(3, null, null);
       head.left.left = new BinaryTreeNode<Integer>(4, null, null);
       head.left.right = new BinaryTreeNode<Integer>(5, null, null);
       head.right.left = new BinaryTreeNode<Integer>(6, null, null);
       head.right.right = new BinaryTreeNode<Integer>(7, null, null);

       orderBinaryTree(head);
    }

    public static ArrayList<Integer> orderBinaryTree(BinaryTreeNode<Integer> head) {
        Deque<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        q.addLast(head);

        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> curr = q.removeFirst();
            res.add(curr.data);

            if (curr.left != null) {
                q.addLast(curr.left);
            }

            if (curr.right != null) {
                q.addLast(curr.right);
            }
        }

        return res;
    }
}

class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left, right;

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
