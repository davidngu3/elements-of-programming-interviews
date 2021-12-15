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

        // additional test
        TreeNodeWithParent g = new TreeNodeWithParent(7, null, null);
        TreeNodeWithParent h = new TreeNodeWithParent(8, null, null);
        TreeNodeWithParent i = new TreeNodeWithParent(9, null, null);
        g.parent = c;
        h.parent = g;
        i.parent = h;

        c.left = g;
        g.left = h;
        h.right = i;

        /* Tree structure
                     a1
                  /     \
                 b2       c3
                / \      /
               d4  e5  g7
              /       /
             f6      h8
                      \
                        i9
        */
        inOrderTraversal(a);
    }

    public static void inOrderTraversal(TreeNodeWithParent l1) {
        boolean terminate = false;
        boolean comeFromLeft = true;

        // go to starting node (leftmost node)
        while (l1.left != null) {
            l1 = l1.left;
        }
        
        TreeNodeWithParent n = l1;

        while (!terminate) { 
            if (comeFromLeft) { // if come from left, process, check right
                System.out.println(n.data);

                if (n.right != null) {
                    n = n.right;
                    // go to leftmost  node
                    while (n.left != null) {
                        n = n.left;
                    }
                }
                else {
                    TreeNodeWithParent p = n.parent;
                    comeFromLeft = (n == p.left) ? true : false;
                    n = n.parent;
                }
            }
            else { // if come from right, go up
                if (n.parent == null) {
                    terminate = true;
                }
                else {
                    TreeNodeWithParent p = n.parent;
                    comeFromLeft = (n == p.left) ? true : false;
                    n = n.parent;
                }
            }
        }
    }
}

