import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Problem10_1 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1, null, null);
        TreeNode b = new TreeNode(2, null, null);
        TreeNode c = new TreeNode(3, null, null);
        TreeNode d = new TreeNode(4, null, null);
        TreeNode e = new TreeNode(5, null, null);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(isHeightBalanced(a));
    }

    public static boolean isHeightBalanced(TreeNode head) {
        // base case, a leaf node: is height balanced
        if (head.left == null && head.right == null) { 
            return true;
        }

        // verify height balance
        if (Math.abs(height(head.left) - height(head.right)) > 1) {
            return true;
        }

        // process left and right subtrees
        return isHeightBalanced(head.left) && isHeightBalanced(head.right);
    }

    public static int height(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }
        if (node.left == null) {
            return height(node.right);
        }
        if (node.right == null) {
            return height(node.left);
        }
        
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}

class TreeNode {
    Integer data;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(Integer data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
