class Problem10_2 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1, null, null);
        TreeNode b = new TreeNode(2, null, null);
        TreeNode c = new TreeNode(2, null, null);
        TreeNode d = new TreeNode(4, null, null);
        TreeNode e = new TreeNode(4, null, null);
        TreeNode f = new TreeNode(5, null, null);
        TreeNode g = new TreeNode(5, null, null);

        a.left = b;
        a.right = c;
        b.left = d;
        c.right = e;
        b.right = f;
        c.left = g;

        /* Tree structure
                    a
                  /   \
                 b     c
                /       \ 
               d         e
        */

        System.out.println(isSymmetrical(a));
    }

    public static boolean isSymmetrical(TreeNode head) {
        return subtreesEquivalent(head.left, head.right);
    }

    // preorder traversal
    public static boolean subtreesEquivalent(TreeNode x, TreeNode y) {
        // base case
        if (x == null && y == null) {
            return true;
        }

        // process roots
        if (x == null || y == null || !x.data.equals(y.data)) {
            return false;
        }

        // process contralateral children
        if (!subtreesEquivalent(x.left, y.right)) {
            return false;
        }

        if (!subtreesEquivalent(x.right, y.left)) {
            return false;
        }
        
        // true
        return true;
    }
}   

