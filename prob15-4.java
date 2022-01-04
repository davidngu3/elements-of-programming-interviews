import java.util.*;

/* strategy
    all keys are distinct
    find the key with a value between values of a and b?
    is there only one key with this value? no
        but: the required one is the first key that exhibits this behaviour

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

        TreeNode res = LCA(head, c, e);
        System.out.println(res.data);
    }

    public static TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
        if (a.data < b.data) {
            return LCAaux(root, a, b);
        }
        else {
            return LCAaux(root, b, a);
        }
    }

    public static TreeNode LCAaux(TreeNode root, TreeNode a, TreeNode b) {
        if (root != null) {
            if (root.data >= a.data && root.data < b.data) {
                return root;
            }
    
            if (root.data < a.data) {
                return LCAaux(root.right, a, b);
            }
    
            if (root.data > b.data) {
                return LCAaux(root.left, a, b);
            }
        }

        return new TreeNode(0, null, null); // wont be hit?
    }
}
