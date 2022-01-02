class Problem15_2 {
    /*
        Strategy: eliminate subtrees with elements which are LESS than the target element
            eliminate based on BST condition
    */
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

        System.out.println(nextGreatestKey(head, 1));
    }

    public static int nextGreatestKey(TreeNode root, int target) {
        return findNextGreatestNode(root, target, Integer.MAX_VALUE);
    }

    public static int findNextGreatestNode(TreeNode node, int target, int candidate) {
        // base case: null node take our best candidate
        if (node == null) {
            return candidate;
        }

        // process root 
        candidate = node.data > target ? Math.min(node.data, candidate) : candidate;

        // choose next subtree based on BST ruling
        if (node.data <= target) {
            return findNextGreatestNode(node.right, target, candidate);
        }
        if (node.data > target) {
            return findNextGreatestNode(node.left, target, candidate);
        }

        return 0; // wont be hit
    }
}
