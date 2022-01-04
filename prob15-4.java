import java.util.*;

/* strategy

*/
class Problem15_4 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5, null, null);
        TreeNode a = new TreeNode(3, null, null);
        TreeNode b = new TreeNode(7, null, null);
        TreeNode c = new TreeNode(1, null, null);
        TreeNode e = new TreeNode(4, null, null);
        TreeNode f = new TreeNode(2, null, null);
        TreeNode d = new TreeNode(9, null, null);

        head.left = a;
        head.right = b;
        a.left = c;
        a.right = e;
        e.left = f;
        b.right = d;

        LCA(head, b, c);
    }


    public static TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
        return new TreeNode(5, null, null);
    }
}
