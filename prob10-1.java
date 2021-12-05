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
        TreeNode f = new TreeNode(6, null, null);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        // d.left = f;

        System.out.println(isHeightBalanced(a));
    }

    public static boolean isHeightBalanced(TreeNode head) {
        return processSubtree(head).isHeightBalanced;
    }

    // postorder traversal
    public static TreeNode processSubtree(TreeNode head) {
        // base case
        if (head == null) {
            return new TreeNode(null, null, null, true, -1);
        }

        // process left and right subtrees        
        TreeNode leftSubtree = processSubtree(head.left);
        if (!leftSubtree.isHeightBalanced) {
            return leftSubtree;
        }

        TreeNode rightSubtree = processSubtree(head.right);
        if (!rightSubtree.isHeightBalanced) {
            return rightSubtree;
        }

        // process current node
        head.isHeightBalanced = (Math.abs(leftSubtree.height - rightSubtree.height) > 1) ? false : true;
        head.height = Math.max(leftSubtree.height, rightSubtree.height) + 1;
        
        return head;
    }
}

class TreeNode {
    Integer data;
    TreeNode left = null;
    TreeNode right = null;
    
    // additional data stored for this problem
    boolean isHeightBalanced;
    int height;

    public TreeNode(Integer data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer data, TreeNode left, TreeNode right, boolean isHeightBalanced, int height) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.isHeightBalanced = isHeightBalanced;
        this.height = height;
    }
}
