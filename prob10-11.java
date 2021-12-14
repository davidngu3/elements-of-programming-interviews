import java.util.*;

class Problem10_11 {
    public static void main(String[] args) {
        TreeNodeWithParent a = new TreeNodeWithParent(1, null, null);
        TreeNodeWithParent b = new TreeNodeWithParent(2, null, null);
        TreeNodeWithParent c = new TreeNodeWithParent(3, null, null);
        TreeNodeWithParent d = new TreeNodeWithParent(4, null, null);
        TreeNodeWithParent e = new TreeNodeWithParent(5, null, null);
        TreeNodeWithParent f = new TreeNodeWithParent(6, null, null);

        a.left = b;
        b.parent = a;

        a.right = c;
        c.parent = a;

        b.left = d;
        d.parent = b;

        b.right = e;
        e.parent = b;

        d.left = f;
        f.parent = d;

        /* Tree structure
                    a1
                  /   \
                 b2     c3
                / \ 
               d4   e5
              /
             f6
        */
        inOrderTraversal(a);
    }

    public static void inOrderTraversal(TreeNodeWithParent l1) {
        // traverse down left subtree
        while (l1.left != null) {
            l1 = l1.left;
            System.out.println(l1.data);
        }
    }
}

