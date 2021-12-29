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

        /* Tree structure
                    a
                  /   \
                 b     c
                / \ 
               d   e
              /
             f
        */

        LCA(c, c);
    }

    public static TreeNodeWithParent LCA(TreeNodeWithParent a, TreeNodeWithParent b) {
        // edge case: null nodes
        if (a == null || b == null) {
            throw new IllegalArgumentException("Null nodes cannot have a common ancestor");
        }

        return b;
    }
}
