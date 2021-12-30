import java.util.*;

/*
strategy:
traverse both nodes upwards in tandem, adding nodes to a hashmap (keyed by node, or value if values are distinct)
if node already contained in hashmap, return the node

this relies on the fact that there are no cycles; so once a common node is seen, and the first one at that, it is the LCA
*/

class Problem13_4 {
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

        TreeNodeWithParent n = LCA(b, i);
        System.out.println(n.data);
    }

    public static TreeNodeWithParent LCA(TreeNodeWithParent a, TreeNodeWithParent b) {
        // edge case: null nodes
        if (a == null || b == null) {
            throw new IllegalArgumentException("Null nodes cannot have a common ancestor");
        }

        HashMap<TreeNodeWithParent, Integer> map = new HashMap<>();

        while (a != null || b != null) {
            if (map.containsKey(a)) {
                return a;
            }
            map.put(a, 1);
            if (map.containsKey(b)) {
                return b;
            }
            map.put(b, 1);

            if (a.parent != null) {
                a = a.parent;
            }
            if (b.parent != null) {
                b = b.parent;
            }
        }

        return new TreeNodeWithParent(null, null, null); // no common ancestor
    }
}
