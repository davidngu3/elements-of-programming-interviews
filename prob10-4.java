class Problem10_4 {
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

    /*
        From node a, trace path back to the root node, storing a boolean to symbolise that the node has been visited. 
            - Alternatively, can set the parent to null to store this information
        From node b, trace back to the root node until a node with (visited = true OR parent = null)
            - Return this node.

        NOTE:
        - Assuming we cannot store extra data, either by hash table or additional node field,
            Calculate the depth of the two nodes, ascent the lower node such that they are the same level,
                Move them in tandem until they reach a common node
    */
    public static TreeNodeWithParent LCA(TreeNodeWithParent a, TreeNodeWithParent b) {
        // edge case: null nodes
        if (a == null || b == null) {
            throw new IllegalArgumentException("Null nodes cannot have a common ancestor");
        }

        while (a != null) {
            a.visited = true;
            a = a.parent;
        }

        while (!b.visited && b.parent != null) {
            b = b.parent;
        }

        return b;
    }
}

class TreeNodeWithParent {
    Integer data = null;
    TreeNodeWithParent left = null;
    TreeNodeWithParent right = null;

    // additional data stored for this problem
    TreeNodeWithParent parent = null;
    boolean visited = false;

    public TreeNodeWithParent(Integer data, TreeNodeWithParent left, TreeNodeWithParent right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
